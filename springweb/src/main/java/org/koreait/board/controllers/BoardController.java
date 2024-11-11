package org.koreait.board.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list/{bid}")
    public String list(@PathVariable(name="bid") String id) { // 경로 변수
        System.out.printf("bid=%s%n", id);
        return "board/list";
    }

    @GetMapping("/write/{bid}")
    public String write(@PathVariable("bid") String id) {
        System.out.printf("bid=%s%n", id);
        return "board/write";
    }

    @PostMapping("/write")
    public String writePs() {
        return "board/list";
    }
}
