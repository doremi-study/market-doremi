package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.domain.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = "com.doremi.marketdoremi")
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void 회원_조회() {
        List<Member> members = repository.findAll();
    }
}