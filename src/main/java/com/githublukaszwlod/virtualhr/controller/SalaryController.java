package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.model.Salary;
import com.githublukaszwlod.virtualhr.service.CurrentUserService;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.PdfService;
import com.githublukaszwlod.virtualhr.service.SalaryService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SalaryController {

   private final EmployeeService employeeService;
   private final SalaryService salaryService;
   private final  PdfService pdfService;
   private final  CurrentUserService currentUserService ;


    public SalaryController(EmployeeService employeeService, SalaryService salaryService, PdfService pdfService, CurrentUserService currentUserService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
        this.pdfService = pdfService;
        this.currentUserService = currentUserService;
    }

    @GetMapping("/salary")
    public String showPersonalData( Model model) {



        Employee employee = employeeService.getOne(currentUserService.getCurrentUserId());
        List<Salary> salaries = salaryService.getAllSalariesByEmployeeId(currentUserService.getCurrentUserId());

        model.addAttribute("user", employee);
        model.addAttribute("salaries", salaries);

        return "salary";
    }


    @GetMapping("/salary/pdf/{id}")
    public void generatePdf(@PathVariable Long id, HttpServletResponse response) throws IOException, DocumentException {
        Salary salary = salaryService.getSalaryById(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + salary.getPayrollPeriod() + ".pdf\"");
        pdfService.generateSalaryPdf(salary, response.getOutputStream());
    }
}
