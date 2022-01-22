package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)//부모 속성 사용 안하고, include라고 명시된것만 포함
@Table(name = "member", uniqueConstraints = @UniqueConstraint(columnNames = {"member_id"}))
@Entity
public class Member implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @EqualsAndHashCode.Include//Entity는 식별할 수 있는 값으로 동등성을 확인해야 한다.
    private MemberId memberId;

    @Embedded
    @Column(name = "password", nullable = false)
    private Password password;

    @OneToMany(mappedBy = "member"
            , cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<MemberAuthority> memberAuthorities;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn()
    private MemberInfo memberInfo;

    /*@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;*/

    @Builder//생성자 위에 빌더 추가
    public Member(String memberId, String password, String grade, MemberInfo memberInfo) {
        this.memberId = new MemberId(memberId);
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
    public void setMemberInfo(MemberInfo memberInfo) {
        memberInfo.addMember(this);
        this.memberInfo = memberInfo;
    }

    public String passwordAsString() {
        return this.password.getPassword();
    }
}
