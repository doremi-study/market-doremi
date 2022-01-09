package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.domain.member.entity.MemberAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoleRepository extends JpaRepository<MemberAuthority, Long> {
}
