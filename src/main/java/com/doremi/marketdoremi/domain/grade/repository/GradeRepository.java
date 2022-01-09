package com.doremi.marketdoremi.domain.grade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doremi.marketdoremi.domain.grade.entity.MemberGrade;
import com.doremi.marketdoremi.domain.member.entity.Grade;

public interface GradeRepository extends JpaRepository<MemberGrade, Grade> {
}
