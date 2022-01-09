package com.doremi.marketdoremi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.doremi.marketdoremi.domain.member.entity.Role;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberDataDto {

    private MemberDto member;

    private MemberInfoDto memberInfo;

    private List<Role> roles;
}
