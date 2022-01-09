package com.doremi.marketdoremi.domain.authority.repository;

import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.member.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Role> {
}
