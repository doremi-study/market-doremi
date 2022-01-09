package com.doremi.marketdoremi.domain.grade.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.doremi.marketdoremi.domain.benefit.entity.Benefit;
import com.doremi.marketdoremi.domain.member.entity.Grade;

@Table(name = "grade")
@Entity
public class MemberGrade {

	@Id
	private Grade gradeName;

	@Embedded
	private GradeStandard gradeStandard;

	@OneToOne(mappedBy = "grade")
	private Benefit benefit;
}
