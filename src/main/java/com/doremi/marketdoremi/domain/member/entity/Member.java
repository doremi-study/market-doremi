package com.doremi.marketdoremi.domain.member.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
