package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.service.member.MemberService;
import com.doremi.marketdoremi.web.dto.MemberDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public String signup(@RequestBody MemberDataDto memberData) {

        String memberId = memberService.joinUser(memberData);
        log.info("user created::" + memberData.getMember().toString());
        return "redirect:/" + memberId;
    }

    @PostMapping("/api/v1/member")
    public ResponseEntity<String> signup(@RequestBody MemberRequest memberRequest) {
        String memberId = memberService.joinMember(memberRequest);
        return ResponseEntity.ok(memberId);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDto memberDto) {
        try {
            String login = memberService.login(memberDto);
            return ResponseEntity.ok(login);
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

