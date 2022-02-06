package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.common.error.exceptions.DoremiRuntimeException;
import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.authority.repository.AuthorityRepository;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import com.doremi.marketdoremi.domain.memberinfo.repository.MemberInfoRepository;
import com.doremi.marketdoremi.codes.Role;
import com.doremi.marketdoremi.web.dto.MemberDataDto;
import com.doremi.marketdoremi.web.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder encoder;
    private final MemberRepository memberRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final AuthorityRepository roleRepository;

    @Transactional
    public String joinMember(MemberDataDto memberData) throws Exception {
        Member member = memberData.toMemberEntity(encoder);
        MemberInfo memberInfo = memberData.toMemberInfoEntity();

        member.setMemberInfo(memberInfo);

        for (Role role : memberData.getRoles()) {
            Authority searchAuthority = roleRepository.findById(role)
                    .orElseThrow(() -> new DoremiRuntimeException("없는 권한입니다."));

            MemberAuthority memberAuthority = new MemberAuthority(member, searchAuthority);

            member.addMemberAuthority(memberAuthority);
        }
        memberRepository.save(member);
        return member.getMemberId().getMemberId();
    }
}
