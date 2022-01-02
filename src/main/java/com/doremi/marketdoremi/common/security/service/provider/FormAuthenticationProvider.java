package com.doremi.marketdoremi.common.security.service.provider;

import com.doremi.marketdoremi.common.security.MemberDetail;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FormAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MemberService memberService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String memberId = authentication.getName();
        String password = (String) authentication.getCredentials();
        MemberDetail memberDetail = (MemberDetail) memberService.loadUserByUsername(memberId);

        if (!passwordEncoder.matches(password, memberDetail.getPassword())) {
            throw new BadCredentialsException("비밀번호가 틀립니다.");
        }
        return new UsernamePasswordAuthenticationToken(memberId, password, memberDetail.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}