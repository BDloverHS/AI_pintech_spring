package org.koreait.global.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    // 검색 혹은 변경(여기서는 검색)
    @GetMapping("/member/login")
    public String login(@RequestParam("name") String name) {

        System.out.printf("name : %s%n", name);

        // templates에 있는 파일 경로
        return "member/form";
    }


    @PostMapping("/member/login")
    public String  loginPs(RequestLogin form) {
        System.out.println(form);
        return "member/form";
    }

    /*
    @PostMapping("/member/login")
    public String loginPs(
            @RequestParam("email") String email,
            @RequestParam("password") String pass,
            @RequestParam(name = "saveEmail", required = false) boolean saveEmail) {


        System.out.println("회원가입 처리 쪽 유입!!");

        System.out.printf("email=%s, password=%s, saveEmail=%s%n", email, pass, saveEmail);
        return "member/form";
    }
     */
}
