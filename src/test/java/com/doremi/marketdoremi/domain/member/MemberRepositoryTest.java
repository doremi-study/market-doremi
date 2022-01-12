package com.doremi.marketdoremi.domain.member;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

//    @After
//    public void cleanup() {
//        memberRepository.deleteAll();
//    }

    @Test
    public void 회원정보추가() {
        memberRepository.save(Member.builder()
                .memberId("admin")
                .name("어드민")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .role("USER")
                .build());
    }

    @Test
    public void 로그인() {

    }


}