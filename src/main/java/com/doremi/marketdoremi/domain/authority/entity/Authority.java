package com.doremi.marketdoremi.domain.authority.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import com.doremi.marketdoremi.domain.member.entity.Role;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;

@NoArgsConstructor @AllArgsConstructor
@Getter @Builder
@Table(name = "authority")
@Entity
public class Authority {

    @Enumerated(EnumType.STRING)
    @Id
    @Column(name = "name")
    private Role name;

    @OneToMany(mappedBy = "authority")// TODO 여기 mappedBy가 굳이 필요한지?
    private List<MemberAuthority> memberAuthorities;
}
