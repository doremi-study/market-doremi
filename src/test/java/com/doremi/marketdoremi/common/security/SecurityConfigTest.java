package com.doremi.marketdoremi.common.security;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class SecurityConfigTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .apply(springSecurity())
                .build();

        Member member = Member.builder()
                .memberId("admin")
                .password(passwordEncoder.encode("admin"))
//                .name("어드민")
//                .role(Role.ADMIN)
                .build();
        memberRepository.save(member);
    }

    @Test
    @DisplayName("Login 테스트")
    public void login_test() throws Exception {
        // given
        String memberId = "admin";
        String password = "admin";

        // when
        mvc.perform(formLogin().user(memberId).password(password))
                .andDo(print())
                // then
                .andExpect(status().is3xxRedirection());
                //.andExpect(redirectedUrl("/"));
    }
}
