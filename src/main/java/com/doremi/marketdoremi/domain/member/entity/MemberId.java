package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class MemberId implements Serializable {

	@Column(name="member_id")
	private String memberId;

	public MemberId(String memberId) {
		this.memberId = memberId;
	}

}
