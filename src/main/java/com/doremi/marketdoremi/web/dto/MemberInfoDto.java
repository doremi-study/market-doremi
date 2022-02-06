package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.memberinfo.entity.Email;
import com.doremi.marketdoremi.domain.memberinfo.entity.Gender;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberAddress;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter @Builder
public class MemberInfoDto {

    private String name;

    private String email;

    private String phoneNumber;

	private String postNo;

	private String roadAddress;

	private String detailAddress;

	private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
