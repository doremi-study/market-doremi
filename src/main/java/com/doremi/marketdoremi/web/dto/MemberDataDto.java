package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.member.entity.MemberRole;
import com.doremi.marketdoremi.domain.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberDataDto {

    private MemberDto member;

    private MemberInfoDto memberInfo;

    private List<com.doremi.marketdoremi.domain.member.Role> roles;

    /*public List<MemberRole> toEntityMemberRoles() {
        return roles.getRole().stream()
                .map(data -> {
                    Role role = Role.builder()
                            .name(data)
                            .build();
                    return MemberRole.builder()
                            .role(role)
                            .build();
                }).collect(Collectors.toList());
    }*/
}
