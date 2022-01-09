package com.doremi.marketdoremi.web.dto;


import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;

import lombok.*;

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
