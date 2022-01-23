package com.doremi.marketdoremi.domain.authority.entity;

import com.doremi.marketdoremi.codes.Role;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Builder
@Table(name = "authority")
@Entity
public class Authority {

    @Enumerated(EnumType.STRING)
    @Id
    @Column(name = "name")
    private Role name;
}
