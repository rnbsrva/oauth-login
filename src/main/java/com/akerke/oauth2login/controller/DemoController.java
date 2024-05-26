package com.akerke.oauth2login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Secured!";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Goodbye, World!";
    }

}
