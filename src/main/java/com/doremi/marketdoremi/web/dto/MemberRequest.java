package com.doremi.marketdoremi.web.dto;

import java.time.LocalDate;

import com.doremi.marketdoremi.domain.memberinfo.entity.Email;
import com.doremi.marketdoremi.domain.memberinfo.entity.Gender;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberAddress;
import org.springframework.format.annotation.DateTimeFormat;

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
	private Gender gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	public Member toEntityMember() {

		return Member.builder()
			.memberId(memberId)
			.password(PasswordEncryptor.encrypt(password))
			.grade(grade)
			.memberInfo(this.toEntityMemberInfo())
			.build();
	}

	private MemberInfo toEntityMemberInfo() {
		return MemberInfo.builder()
//			.memberId(memberId)
				.email(Email.builder().email(email).build())
				.phoneNumber(phoneNumber)
				.address(MemberAddress.builder()
						.postNo(postNo)
						.roadAddress(roadAddress)
						.detailAddress(detailAddress)
						.build())
				.gender(gender)
				.birthday(birthday)
				.build();
	}
}
