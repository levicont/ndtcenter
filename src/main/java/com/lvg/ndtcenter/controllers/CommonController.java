package com.lvg.ndtcenter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Victor Levchenko LVG Corp. on 09.01.17.
 */
@RestController
public class CommonController {

    @RequestMapping("/")
    public String home(){
        return "Welcome to home Page!";
    }
}
