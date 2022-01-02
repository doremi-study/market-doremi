package com.doremi.marketdoremi.service.member;

import com.doremi.marketdoremi.common.security.MemberDetail;
import com.doremi.marketdoremi.domain.member.Role;
import com.doremi.marketdoremi.domain.member.entity.Member;
import com.doremi.marketdoremi.domain.member.repository.MemberRepository;
import com.doremi.marketdoremi.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public String joinUser(MemberDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        return memberRepository.save(memberDto.toEntity()).getMemberId();
    }


   @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole().toString()));

        return MemberDetail.builder()
                .memberId(member.getMemberId())
                .password(member.getPassword())
                .authorities(roles)
                .build();
    }
}
