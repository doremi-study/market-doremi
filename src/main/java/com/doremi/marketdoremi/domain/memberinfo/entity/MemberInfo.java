package com.doremi.marketdoremi.domain.memberinfo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Entity
public class MemberInfo {

	@EmbeddedId
	private MemberId memberId;

	@Column(name = "name", nullable = false)
	private String name;

	@Embedded
	private Email email;

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = true)
	private Gender gender;

	@Column
	private LocalDate birthday;

	@Column(name = "birthday", nullable = false)
	private MemberAddress address;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@Builder
	public MemberInfo(String memberId, String name, String email, String phoneNumber,
		String gender, LocalDate birthday, String postNo, String roadAddress, String detailAddress) {
		this.memberId = new MemberId(memberId);
		this.name = name;
		this.email = new Email(email);
		this.phoneNumber = phoneNumber;
		this.gender = Gender.of(gender);
		this.birthday = birthday;
		this.address = new MemberAddress(postNo, roadAddress, detailAddress);
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
