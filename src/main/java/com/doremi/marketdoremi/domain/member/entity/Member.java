package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "member", uniqueConstraints = @UniqueConstraint(columnNames = {"member_id"}))
@Entity
public class Member implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name =" member_id", nullable = false)
    private String memberId;

    @Embedded
    private Password password;

    @OneToMany(mappedBy = "member"
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<MemberAuthority> memberAuthorities;

    @OneToOne(mappedBy = "member"
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private MemberInfo memberInfo;

    /*@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;*/

    @Builder//생성자 위에 빌더 추가
    public Member(String memberId, String password, String grade, MemberInfo memberInfo) {
        this.memberId = memberId;
        this.password = new Password(password);
//        this.grade = Grade.of(grade);
        this.memberInfo = memberInfo;
    }

    /**
     * memberAuthority 값 매핑
     */
    public void addMemberAuthority(MemberAuthority memberAuthority) {
        if (this.memberAuthorities == null) {
            memberAuthorities = new ArrayList<>();
        }
        memberAuthorities.add(memberAuthority);
    }

    /**
     * memberInfo 값 매핑
     */
    public void addMemberInfo(MemberInfo memberInfo) {
        memberInfo.addMember(this);
        this.memberInfo = memberInfo;
    }

    public String passwordAsString() {
        return this.password.getPassword();
    }
}
