package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.service.member.MemberService;
import com.doremi.marketdoremi.web.dto.MemberDataDto;
import com.doremi.marketdoremi.web.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<String> signup(@RequestBody MemberDataDto memberData) {
        String memberId = memberService.joinUser(memberData.getMember(), memberData.getMemberInfo(), memberData.getRoles());
        log.info("user created::" + memberData.getMember().toString());
        return ResponseEntity.ok(memberId);
    }

    @PostMapping("/api/v1/member")
    public ResponseEntity<String> signup(@RequestBody MemberRequest memberRequest) {
        String memberId = memberService.joinMember(memberRequest);
        return ResponseEntity.ok(memberId);
    }

    /*
    * memberService.login 이거 삭제했는데 너무 거침없이 삭제했니..
    * */
    /*@GetMapping("/login")
    public ResponseEntity<MemberDetail> login(@RequestBody MemberDto memberDto) {
        try {
            MemberDetail member = memberService.login(memberDto);
            return new ResponseEntity<>(member, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }*/

}

