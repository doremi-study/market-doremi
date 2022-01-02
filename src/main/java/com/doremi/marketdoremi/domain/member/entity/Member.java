package com.doremi.marketdoremi.domain.member.entity;

import com.doremi.marketdoremi.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 500, nullable = false)
    private String memberId;

    @Column(length = 500, nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
//    private Grade grade;

    @Builder
    public Member(String memberId, String password, String name, Role role) { //builder의 parameter를 추리는 기준이 뭘까?
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
