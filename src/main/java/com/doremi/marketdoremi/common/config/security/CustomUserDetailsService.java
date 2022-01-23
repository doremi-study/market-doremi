package com.doremi.marketdoremi.common.config.security;

import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.entity.MemberId;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.domain.memberauthority.entity.MemberAuthority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		Member member = memberRepository.findById(new MemberId(memberId))
			                        .orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
		List<GrantedAuthority> roles = new ArrayList<>();
		for (MemberAuthority memberAuthority : member.getMemberAuthorities()) {
			roles.add(new SimpleGrantedAuthority(memberAuthority.getAuthority().getName().toString()));
		}

		return MemberDetail.builder()
			.memberId(member.getMemberId().getMemberId())
			.password(member.passwordAsString())
			.authorities(roles)
			.build();
	}
}
