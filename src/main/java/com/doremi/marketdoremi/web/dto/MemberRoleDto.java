package com.doremi.marketdoremi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberRoleDto {

    private List<com.doremi.marketdoremi.domain.member.Role> role;
}
