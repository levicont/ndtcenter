package com.lvg.ndtcenter.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import java.time.LocalDate

@Controller
class CommonController {

    @RequestMapping("/")
    public String index(){
        return "home"
    }

    @RequestMapping(value = "/home")
    String home(Map<String, Object> model){
        def date = LocalDate.now()

        model.put("date",date)
        return "redirect:/"
    }


}
