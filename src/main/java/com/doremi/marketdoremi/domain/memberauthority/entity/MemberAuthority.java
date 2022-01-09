package com.doremi.marketdoremi.domain.memberauthority.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.member.entity.Member;

@Getter
@NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "member_authority")
@Entity
public class MemberAuthority {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id", nullable = false, insertable = true)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "authority_name", nullable = false, insertable = true)
    private Authority authority;

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
