package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.member.entity.MemberInfo;
import com.doremi.marketdoremi.web.Sex;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    private String address;

    private Sex sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public MemberInfo toEntity() {
        return MemberInfo.builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(address)
                .sex(sex)
                .birthday(birthday)
                .build();
    }
}
