package com.doremi.marketdoremi.domain.memberinfo.repository;

import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

}
