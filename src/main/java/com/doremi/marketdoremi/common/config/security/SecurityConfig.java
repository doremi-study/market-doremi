package com.doremi.marketdoremi.common.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring Security에서는 위와 같이 @EnableWebSecurity 설정 시, 인증을 요청하는 페이지를 보여줌
    // WebSecurityConfigurer를 구현하고 이를 구성으로 노출하여 WebSecurity를 사용자 정의 할 수 있습니다. EnableWebSecurity를 사용할 때이 구성을 가져옵니다.

    private final CustomUserDetailsService userDetailsService;
    //private final FormAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         // configure(HttpSecurity) 메서드에서 HttpSecurity 객체는 현재 로그인한 사용자가 적절한 역할과 연결되어 있는지 확인하는 서블릿 필터를 생성한다.
        http
                .csrf().disable()
                //.headers().frameOptions().disable() //h2 웹콘솔 보여주기 위한 설정
            //.and()
                .authorizeRequests()
                // HttpServletRequest에 따라 접근(access)을 제한합니다.
                // authorizeRequests() : 모든 request를 인증
                //.antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/member").permitAll()
                .antMatchers("/login").permitAll()
                // antMatchers().hasRole() : 특정 URI를 특정 role을 갖는 계정만 접근할 수 있음
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .usernameParameter("memberId")
                .passwordParameter("password")
                .permitAll()
            .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
        //deleteCookie & invalidSession을 추가
        ;
    }

    //BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 암호화 객체.
    //Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 세부 서비스를 설정하기 위한 오버라이딩
        // configure(AuthenticationManagerBulider) 메서드에서 AuthenticationManagerBuilder 객체는 스프링 시큐리티가 사용자를 인증하는 방법을 설정한다.
//        super.configure(auth);

        // 아래의 경우, 인메모리 데이터 저장소를 이용해 사용자명과 패스워드를 비교한다.
        /*auth.inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("user").password(encoder().encode("user")).roles("USER");*/

        // AuthenticationManagerBuilder를 사용해 어떠한 계정의 어떠한 role을 갖는지 설정
        // admin ->  "ADMIN"
        // user  ->  "USER"
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //HttpSecurity : security Filter 를 타면서 제어
        //WebSecurity  : security Filter 를 탈지 말지 결정
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }



}
