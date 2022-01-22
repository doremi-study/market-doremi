package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.domain.member.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter @ToString
@Builder @AllArgsConstructor @NoArgsConstructor
public class MemberDto {
    private String memberId;
    private String password;

    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

    public Member toEntity(){
        return Member.builder()
                .memberId(memberId)
                .password(password)
                .build();
    }
}
