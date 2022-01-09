package com.doremi.marketdoremi.domain.benefit.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.doremi.marketdoremi.domain.grade.entity.MemberGrade;

@Entity
public class Benefit {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;

	@OneToOne
	@JoinColumn(name = "grade_name")
	private MemberGrade memberGrade;

	// @Id
	// private Grade grade;

	@Column
	private BigDecimal accumulationRate;
}
