package com.doremi.marketdoremi.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "member_role")
@Entity
public class MemberRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id", nullable = false, insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_name", nullable = false, insertable = true)
    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
