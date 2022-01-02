package com.doremi.marketdoremi.domain.member.repository;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, MemberId> {
}
