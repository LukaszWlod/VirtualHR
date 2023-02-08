package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@AllArgsConstructor
public class UserController {

    EmployeeService employeeService;

    @GetMapping("/user")
    public String getUserForm(Model model) {
        model.addAttribute("user", employeeService.getOne(1L));
        return "user";
    }

    @PostMapping("/generate-pdf")
    public void generatePdf(@ModelAttribute Employee user, HttpServletResponse response) throws Exception {
        // Generate PDF using the user data
        // ...

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=user.pdf");

        // Stream the generated PDF to the response
        // ...
    }
}

