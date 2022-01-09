package com.doremi.marketdoremi.domain.memberinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doremi.marketdoremi.domain.member.entity.MemberId;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, MemberId> {
}
