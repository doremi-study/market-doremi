package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.common.config.security.MemberDetail;
import com.doremi.marketdoremi.domain.authority.entity.Authority;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import com.doremi.marketdoremi.domain.member.entity.Role;
import com.doremi.marketdoremi.domain.authority.repository.AuthorityRepository;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.memberauthority.repository.MemberAuthorityRepository;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import com.doremi.marketdoremi.domain.memberinfo.repository.MemberInfoRepository;
import com.doremi.marketdoremi.web.dto.MemberDataDto;
import com.doremi.marketdoremi.web.dto.MemberDto;
import com.doremi.marketdoremi.web.dto.MemberInfoDto;
import com.doremi.marketdoremi.web.dto.MemberRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
	private final MemberInfoRepository memberInfoRepository;
    private final MemberAuthorityRepository memberAuthorityRepository;
    private final AuthorityRepository authorityRepository;

	private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;

    @Transactional
    public String joinUser(MemberDataDto memberData) {
        MemberDto memberDto = memberData.getMember();
        MemberInfoDto memberInfoDto = memberData.getMemberInfo();

        // 비밀번호 암호화
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));

        Member member = memberDto.toEntity();
        MemberInfo memberInfo = memberInfoDto.toEntity();

        for (Role role : memberData.getRoles()) {
            //  TODO role이 존재하는지 조회했는데
            Authority searchAuthority = authorityRepository.findById(role).get();

            MemberAuthority memberAuthority = MemberAuthority.builder()
                    .member(member)
                    .authority(searchAuthority)
                    .build();
            memberAuthority.setMember(member);

            member.addMemberAuthority(memberAuthority);
            //    TODO 이상적으로는 memberRepository.save(member)하고싶은데... memberRole이랑 memberInfo랑 하게됨. 안그러면 null들어감..ㅠ
            memberAuthorityRepository.save(memberAuthority);
        }
        memberInfo.setMember(member);
        memberInfoRepository.save(memberInfo);
        return null;
    }

	@Transactional
	public String joinMember(MemberRequest memberRequest) {
		Member member = memberRequest.toEntityMember();
		//MemberInfo memberInfo = memberRequest.toEntityMemberInfo();

		memberRepository.save(member);
		//memberInfoRepository.save(memberInfo);
		return member.memberIdAsString();
	}

	@Transactional
	public MemberDetail login(MemberDto request) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getMemberId(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return (MemberDetail) authentication.getPrincipal();
	}
}
