package org.koreait.member.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member")
public class MemberController {

    // @GetMapping("/member/login")
    /*
    @RequestMapping(path = {"/member/login", "/user/login"},  method = {RequestMethod.GET, RequestMethod.POST})
    public String login() {

        System.out.println("로그인 페이지 유입!");
        return "member/form";
    }
    */

    @GetMapping("/login") // /member/login
    public String login() {
        return "member/form";
    }

    @PostMapping("/login")
    public String loginPs() {
        return "member/form";
    }

    @GetMapping("/join")
    public String join() {
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String joinPs() {
        return "member/joinForm";
    }
}