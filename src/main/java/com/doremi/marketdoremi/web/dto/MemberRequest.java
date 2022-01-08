package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.common.utils.PasswordEncryptor;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class MemberRequest {
	private String memberId;
	private String password;
	private String name;
	private String role;
	private String grade;
	private String email;
	private String phoneNumber;
	private String postNo;
	private String roadAddress;
	private String detailAddress;
	private String gender;
	private String birthday;

	public Member toEntityMember() {
		return Member.builder()
			.memberId(memberId)
			.password(PasswordEncryptor.encrypt(password))
			.name(name)
			.role(role)
			.grade(grade)
			.build();
	}

	public MemberInfo toEntityMemberInfo() {
		return MemberInfo.builder()
			.memberId(memberId)
			.email(email)
			.phoneNumber(phoneNumber)
			.postNo(postNo)
			.roadAddress(roadAddress)
			.detailAddress(detailAddress)
			.gender(gender)
			.birthday(birthday)
			.build();
	}
}