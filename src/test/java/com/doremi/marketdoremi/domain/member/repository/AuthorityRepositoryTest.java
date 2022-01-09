package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.domain.member.entity.Authority;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

@DataJpaTest// 자동으로 embeddedDatabase를 사용. @Transactional (무조건 rollback)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//  연결하고자 하는 database 그대로 사용하도록 Replace.NONE
@ComponentScan(basePackages = "com.doremi.marketdoremi")
class AuthorityRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Rollback(value = false)
    void 권한_생성() {
        Authority admin = Authority.builder()
                .name(com.doremi.marketdoremi.domain.member.Role.ADMIN)
                .build();
        roleRepository.save(admin);
        Authority user = Authority.builder()
                .name(com.doremi.marketdoremi.domain.member.Role.USER)
                .build();
        roleRepository.save(user);
    }
}