package com.doremi.marketdoremi.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Builder
@Table(name = "role")
@Entity
public class Role {

    @Enumerated
    @Id
    @Column(name = "name")
    private com.doremi.marketdoremi.domain.member.Role name;

    @OneToMany(mappedBy = "role")
    private List<MemberRole> memberRoles;
}
