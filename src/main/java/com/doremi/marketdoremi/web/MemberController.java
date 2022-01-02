package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.service.member.MemberService;
import com.doremi.marketdoremi.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public String signup(@RequestBody MemberDto requestDto) {
        String memberId = memberService.joinUser(requestDto);
        log.info("user created::" + requestDto.toString());
        return "redirect:/" + memberId;
    }
}

