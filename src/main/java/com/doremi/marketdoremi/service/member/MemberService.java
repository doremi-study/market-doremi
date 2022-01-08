package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.common.config.security.CustomUserDetailsService;
import com.doremi.marketdoremi.common.config.security.MemberDetail;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.memberinfo.entity.MemberInfo;
import com.doremi.marketdoremi.domain.memberinfo.repository.MemberInfoRepository;
import com.doremi.marketdoremi.web.dto.MemberDto;
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
    private final PasswordEncoder encoder;
	private final AuthenticationManager authenticationManager;

    @Transactional
    public String joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).memberIdAsString();
    }

	@Transactional
	public String joinMember(MemberRequest memberRequest) {
		Member member = memberRequest.toEntityMember();
		MemberInfo memberInfo = memberRequest.toEntityMemberInfo();

		memberRepository.save(member);
		memberInfoRepository.save(memberInfo);
		return member.memberIdAsString();
	}

	@Transactional
	public String login(MemberDto request) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getMemberId(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		MemberDetail principal = (MemberDetail) authentication.getPrincipal();
		return principal.getUsername();
	}
}
