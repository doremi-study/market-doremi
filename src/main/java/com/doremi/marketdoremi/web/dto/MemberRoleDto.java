package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.web.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberRoleDto {

    private List<Role> role;
}
