package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member implements Serializable {

    @EmbeddedId
    private MemberId memberId;

    @Embedded
    private Password password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    @Builder//생성자 위에 빌더 추가
    public Member(String memberId, String password, String name, Role role, Grade grade) {
        this.memberId = new MemberId(memberId);
        this.password = new Password(password);
        this.name = name;
        this.role = role;
        this.grade = grade;
    }

    public String memberIdAsString(){
        return this.memberId.getMemberId();
    }

    public String passwordAsString() {
        return this.password.getPassword();
    }
}
