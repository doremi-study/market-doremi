package com.doremi.marketdoremi.common.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
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

    private final CustomUserDetailsService userDetailsService;

    //Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(); //SpringSecurity에서 제공하는 비밀번호 암호화 객체.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/member", "/api/v1/member").permitAll()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/login").permitAll()
                // antMatchers().hasRole() : 특정 URI를 특정 role을 갖는 계정만 접근할 수 있음
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
             .and()
                 .formLogin()
                 .usernameParameter("memberId")
                 .permitAll()
            .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 세부 서비스를 설정하기 위한 오버라이딩
        // AuthenticationManagerBuilder 객체는 스프링 시큐리티가 사용자를 인증하는 방법을 설정한다.
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder())
        ;
    }

    @Override
    public void configure(WebSecurity web) {
        // 스프링 부트가 제공하는 static 리소스들의 기본위치를 다 가져와서 스프링 시큐리티에서 제외
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    /*@Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/
}
