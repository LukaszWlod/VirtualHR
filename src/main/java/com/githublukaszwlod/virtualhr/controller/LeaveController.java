package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.LeaveDays;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.LeaveDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaveController {
    private final LeaveDaysService leaveDaysService;
    private final EmployeeService employeeService;



    @Autowired
    public LeaveController(LeaveDaysService leaveDaysService, EmployeeService employeeService) {
        this.leaveDaysService = leaveDaysService;
        this.employeeService = employeeService;


    }




    @GetMapping("/leave")
    public String showLeaveDays(Model model) {
        LeaveDays leaveDays = leaveDaysService.getByEmployeeId(this.getCurrentUserId()) ;

        model.addAttribute("leaveDays", leaveDays);

        return "leave-days";
}

    private Long getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         Long currentUserId = Long.valueOf(authentication.getName());
         return currentUserId;

    }



}
