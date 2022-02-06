package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.codes.Role;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.memberinfo.entity.Email;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberAddress;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MemberDataDto {

    private MemberDto member;

    private MemberInfoDto memberInfo;

    private List<Role> roles;

    public Member toMemberEntity(PasswordEncoder encoder) {
        member.encodePassword(encoder);
        return Member.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .build();
    }

    public MemberInfo toMemberInfoEntity() {
        return MemberInfo.builder()
                .name(memberInfo.getName())
                .email(Email.builder().email(memberInfo.getEmail()).build())
                .phoneNumber(memberInfo.getPhoneNumber())
                .address(MemberAddress.builder()
                        .postNo(memberInfo.getPostNo())
                        .roadAddress(memberInfo.getRoadAddress())
                        .detailAddress(memberInfo.getDetailAddress())
                        .build())
                .gender(memberInfo.getGender())
                .birthday(memberInfo.getBirthday())
                .build();
    }
}
