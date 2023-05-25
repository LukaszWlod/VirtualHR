package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.LeaveDays;
import com.githublukaszwlod.virtualhr.service.LeaveDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaveController {
    private final LeaveDaysService leaveDaysService;

    @Autowired
    public LeaveController(LeaveDaysService leaveDaysService) {
        this.leaveDaysService = leaveDaysService;
    }

    @GetMapping("/leave")
    public String showLeaveDays(Model model) {
        LeaveDays leaveDays = leaveDaysService.getById(1l) ;

        model.addAttribute("leaveDays", leaveDays);

        return "leave-days";
}



}
