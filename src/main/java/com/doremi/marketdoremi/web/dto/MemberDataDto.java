package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.web.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberDataDto {

    private MemberDto member;

    private MemberInfoDto memberInfo;

    private List<Role> roles;
}
