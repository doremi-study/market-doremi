package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.authority.repository.AuthorityRepository;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import com.doremi.marketdoremi.domain.memberinfo.repository.MemberInfoRepository;
import com.doremi.marketdoremi.codes.Role;
import com.doremi.marketdoremi.web.dto.MemberDto;
import com.doremi.marketdoremi.web.dto.MemberInfoDto;
import com.doremi.marketdoremi.web.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder encoder;
    private final MemberRepository memberRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final AuthorityRepository roleRepository;

    @Transactional
    public String joinUser(MemberDto memberDto, MemberInfoDto memberInfoDto, List<Role> roles) {
        // 비밀번호 암호화
        memberDto.encodePassword(encoder);

        Member member = memberDto.toEntity();
        MemberInfo memberInfo = memberInfoDto.toEntity();

        member.setMemberInfo(memberInfo);

        for (Role role : roles) {
            Authority searchAuthority = roleRepository.findById(role).get();

            MemberAuthority memberAuthority = new MemberAuthority(member, searchAuthority);

            member.addMemberAuthority(memberAuthority);
        }
        memberRepository.save(member);
        return member.getMemberId().getMemberId();
    }

    @Transactional
    public String joinMember(MemberRequest memberRequest) {
        Member member = memberRequest.toEntityMember();
        MemberInfo memberInfo = memberRequest.toEntityMember().getMemberInfo();

        memberRepository.save(member);
        memberInfoRepository.save(memberInfo);
        return member.getMemberId().getMemberId();
    }
}
