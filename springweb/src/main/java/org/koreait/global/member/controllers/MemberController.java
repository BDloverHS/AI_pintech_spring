package org.koreait.global.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    // 검색 혹은 변경(여기서는 검색)
    @GetMapping("/member/login")
    public String login() {
        // templates에 생성될 경로
        return "member/form";
    }
}
