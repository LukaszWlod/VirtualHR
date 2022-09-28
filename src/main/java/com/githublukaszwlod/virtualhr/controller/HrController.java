package com.githublukaszwlod.virtualhr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("virtualHr")
public class HrController {

    @GetMapping("getHr")
    public String getHr(){
        return "hr";
    }

}
