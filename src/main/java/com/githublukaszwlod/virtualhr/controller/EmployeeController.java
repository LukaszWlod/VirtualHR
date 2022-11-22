package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.PdfGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;

import java.util.List;

@Controller
@RequestMapping("/employees")

public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployees(Model model){
        model.addAttribute("employee",new Employee());
        List<Employee> employeesList = employeeService.getEmployees();
        model.addAttribute("employeesList",employeesList);

        for (var employee: employeesList
             ) {
            System.out.println("Odczyt z bazy: "+(employee.toString()));
        }
        return "employees";
    }

    @PostMapping
    public String addEmployee (@ModelAttribute("employee") Employee employee){
        employeeService.safeEmployee(employee);

        System.out.println("Zapis do bazy: " + employee.toString() );
        return "redirect:/employees";
    }

    @RequestMapping(value="/edit",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editEntry(@ModelAttribute Employee employee){
        employeeService.update(employee);
        return "redirect:/employees";
    }





    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport() {

        var employees = (List<Employee>) employeeService.getEmployees();

        ByteArrayInputStream bis = PdfGenerator.employeesReport(employees);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employees.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }









}
