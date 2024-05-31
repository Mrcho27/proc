package com.example.proc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class UserController {
    @GetMapping("/user/filter01")
    public String filter01(){
        log.info("=================핸들러 메소드가 실행됐다.==================");
        return "user/test";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/in")
    public String in(HttpSession session){
        session.setAttribute("userId", 1L);
        return "user/in";
    }

}
