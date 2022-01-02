package com.doremi.marketdoremi.domain.member;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
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
                .role(Role.ADMIN)
                .build());
    }

    @Test
    public void 로그인() {

    }


}