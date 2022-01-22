package com.doremi.marketdoremi.domain.memberinfo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class MemberAddress {

	@Column
	private String postNo;

	@Column
	private String roadAddress;

	@Column
	private String detailAddress;

	@Builder
	public MemberAddress(String postNo, String roadAddress, String detailAddress) {
		this.postNo = postNo;
		this.roadAddress = roadAddress;
		this.detailAddress = detailAddress;
	}
}
