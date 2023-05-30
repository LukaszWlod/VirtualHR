package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.*;
import com.githublukaszwlod.virtualhr.service.CurrentUserService;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.LeaveDataService;
import com.githublukaszwlod.virtualhr.service.LeaveDaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Controller
public class LeaveController {
    private final LeaveDaysService leaveDaysService;
    private final CurrentUserService currentUserService;
    private final EmployeeService employeeService;
    private final LeaveDataService leaveDataService;




    @Autowired
    public LeaveController(LeaveDaysService leaveDaysService, EmployeeService employeeService, CurrentUserService currentUserService,LeaveDataService leaveDataService) {
        this.leaveDaysService = leaveDaysService;
        this.employeeService = employeeService;
        this.currentUserService = currentUserService;
        this.leaveDataService = leaveDataService;


    }




    @GetMapping("leave")
    public String showLeaveDays(Model model) {
        LeaveDays leaveDays = leaveDaysService.getByEmployeeId(currentUserService.getCurrentUserId()) ;


        model.addAttribute("leaveDays", leaveDays);

        return "leave-days";
}


    @PostMapping("/public/save")
    public ResponseEntity<String> save (@RequestBody RequestLeaveData requestData) {

        Employee employee = employeeService.getOne(currentUserService.getCurrentUserId());
        LeaveData leaveData = new LeaveData();
        leaveData.setEmployee(employee);
        leaveData.setStartDate(LocalDate.parse(requestData.getDateIn()));
        leaveData.setEndDate(LocalDate.parse(requestData.getDateOut()));
        leaveData.setLeaveDays(requestData.getLeaveDays());
        leaveData.setLeaveType(LeaveType.REQUESTED);

        leaveDataService.saveLeaveData(leaveData);



        LeaveDays leaveDays = leaveDaysService.getByEmployeeId(currentUserService.getCurrentUserId()) ;
        leaveDays.setRequestedLeaveDays(leaveDays.getRequestedLeaveDays()- requestData.getLeaveDays());
        leaveDaysService.update(leaveDays);




        return ResponseEntity.ok("Zapisano dane");


    }
}




