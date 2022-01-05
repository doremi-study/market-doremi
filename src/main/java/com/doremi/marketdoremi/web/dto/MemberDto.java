package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.member.entity.Role;
import com.doremi.marketdoremi.domain.member.entity.Member;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String password;
    private String name;
    private Role role;

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .name(name)
                .role(role)
                .build();
    }

    @Builder
    public MemberDto(String memberId, String password, String name, Role role) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.role = role;
    }}
