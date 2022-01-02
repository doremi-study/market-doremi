package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.service.member.MemberService;
import com.doremi.marketdoremi.web.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

/*
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
*/

    @PostMapping("/signup")
    public String signup(MemberDto requestDto) {
        memberService.joinUser(requestDto);
        log.info("user created::" + requestDto.toString());
        return "redirect:/";
    }
}

