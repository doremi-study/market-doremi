package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;

@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member implements Serializable {

    @EmbeddedId
    private MemberId memberId;

    @Embedded
    private Password password;

    @OneToMany(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<MemberAuthority> memberAuthorities;

    //  @OneToOne에 mappedBy뺐더니 Member에 member_info_idx 컬럼 생기더라
    @OneToOne(mappedBy = "member", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private MemberInfo memberInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    @Builder//생성자 위에 빌더 추가
    public Member(String memberId, String password, String name, String role, String grade, MemberInfo memberInfo) {
        this.memberId = new MemberId(memberId);
        this.password = new Password(password);
        // this.name = name;
        // this.role = Role.of(role);
        this.grade = Grade.of(grade);
        this.memberInfo = memberInfo;
    }

    // @Builder
    // public Member(MemberId memberId, Password password, String name, Role role,
    //     Grade grade) {
    //     this.memberId = memberId;
    //     this.password = password;
    //     this.name = name;
    //     this.role = role;
    //     this.grade = grade;
    // }

    public String memberIdAsString(){
        return this.memberId.getMemberId();
    }

    public String passwordAsString() {
        return this.password.getPassword();
    }

    public void addMemberAuthority(MemberAuthority memberAuthority) {
        if (this.memberAuthorities == null) {
            memberAuthorities = new ArrayList<>();
        }
        memberAuthority.setMember(this);
        memberAuthorities.add(memberAuthority);
    }

    @Builder
    public Member(String memberId, String password, String name, Authority role) { //builder의 parameter를 추리는 기준이 뭘까?
        this.memberId = new MemberId(memberId);
        this.password = new Password(password);
    }
}
