package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.web.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public String joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        memberDto.setPassword(encoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).memberIdAsString();
    }


}
