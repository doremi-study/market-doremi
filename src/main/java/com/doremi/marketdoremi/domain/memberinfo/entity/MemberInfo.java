package com.doremi.marketdoremi.domain.memberinfo.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.doremi.marketdoremi.domain.member.entity.MemberId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Entity
public class MemberInfo {

	@EmbeddedId
	private MemberId memberId;

	@Embedded
	private Email email;

	@Column
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;

	@Column
	private LocalDate birthday;

	@Embedded
	private MemberAddress address;

	@Builder
	public MemberInfo(String memberId, String email, String phoneNumber,
		String gender, String birthday, String postNo, String roadAddress, String detailAddress) {
		this.memberId = new MemberId(memberId);
		this.email = new Email(email);
		this.phoneNumber = phoneNumber;
		this.gender = Gender.of(gender);
		this.birthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
		this.address = new MemberAddress(postNo, roadAddress, detailAddress);
	}

}
