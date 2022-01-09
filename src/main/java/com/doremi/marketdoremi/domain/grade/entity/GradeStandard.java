package com.doremi.marketdoremi.domain.grade.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class GradeStandard {
	@Column
	private long gradeStandardAmont; //누적 금액

	@Column
	private int month; //누적 기준 달
}
