package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.model.Salary;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SalaryController {

    EmployeeService employeeService;
    SalaryService salaryService;

    @Autowired
    public SalaryController(EmployeeService employeeService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
    }

    @GetMapping("/salary/{id}")
    public String showPersonalData(@PathVariable Long id, Model model) {

        Employee employee = employeeService.getOne(id);
        List<Salary> salaries = salaryService.getAllSalariesByEmployeeId(id);

        model.addAttribute("user", employee);
        model.addAttribute("salaries", salaries);

        return "salary";
    }
}
