package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.memberinfo.entity.Gender;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MemberInfoDto {

	private String name;

	private String email;

	private String phoneNumber;

	private String postNo;

	private String roadAddress;

	private String detailAddress;

	private String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	public MemberInfo toEntity() {

		return MemberInfo.builder()
			.name(name)
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
