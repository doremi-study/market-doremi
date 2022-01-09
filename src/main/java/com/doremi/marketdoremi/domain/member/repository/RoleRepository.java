package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.domain.member.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Authority, com.doremi.marketdoremi.domain.member.Role> {
}
