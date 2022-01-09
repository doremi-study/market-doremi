package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.domain.member.Role;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberInfo;
import com.doremi.marketdoremi.domain.member.entity.MemberRole;
import com.doremi.marketdoremi.domain.member.repository.MemberInfoRepository;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.member.repository.MemberRoleRepository;
import com.doremi.marketdoremi.domain.member.repository.RoleRepository;
import com.doremi.marketdoremi.web.dto.MemberDataDto;

import com.doremi.marketdoremi.web.dto.MemberDto;
import com.doremi.marketdoremi.web.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final MemberRoleRepository memberRoleRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public String joinUser(MemberDataDto memberData) {
        MemberDto memberDto = memberData.getMember();
        MemberInfoDto memberInfoDto = memberData.getMemberInfo();

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        Member member = memberDto.toEntity();
        MemberInfo memberInfo = memberInfoDto.toEntity();
        for (Role role : memberData.getRoles()) {
            com.doremi.marketdoremi.domain.member.entity.Role searchRole = roleRepository.findById(role).get();
            MemberRole memberRole = MemberRole.builder()
                    .member(member)
                    .role(searchRole)
                    .build();
            memberRole.setMember(member);
            member.addMemberRole(memberRole);
            memberRoleRepository.save(memberRole);
        }
//        Member save = memberRepository.save(member);
        memberInfo.setMember(member);
        memberInfoRepository.save(memberInfo);
        return null;
    }


}
