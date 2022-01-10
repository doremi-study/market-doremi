package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.web.Role;
import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.authority.repository.AuthorityRepository;
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
    private AuthorityRepository roleRepository;

    @Test
    @Rollback(value = false)
    void 권한_생성() {
        Authority admin = Authority.builder()
                .name(Role.ADMIN)
                .build();
        roleRepository.save(admin);
        Authority user = Authority.builder()
                .name(Role.USER)
                .build();
        roleRepository.save(user);
    }
}