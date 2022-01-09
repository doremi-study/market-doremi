package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.member.Role;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.web.Sex;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String password;

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .build();
    }
}
