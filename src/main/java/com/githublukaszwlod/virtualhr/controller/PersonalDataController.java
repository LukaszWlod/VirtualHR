package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.PdfService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@AllArgsConstructor
public class PersonalDataController {

   private EmployeeService employeeService;
   private PdfService pdfService;


    @GetMapping("/personalData")
    public String getUserForm(Model model) {
        model.addAttribute("user", employeeService.getOne(1L));
        return "personalData";
    }

    @GetMapping("/personalData/{id}/pdf")
    public void generatePdf(@PathVariable Long id, HttpServletResponse response) throws IOException, DocumentException {
        Employee employee = employeeService.getOne(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + employee.getName() + ".pdf\"");
        pdfService.generatePersonalDataPdf(employee, response.getOutputStream());
    }


}

