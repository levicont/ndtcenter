package com.lvg.ndtcenter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @RequestMapping("/")
    public String home(){
        return "Welcome to home Page!";
    }
}
