package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.service.EmployeeService;
import com.githublukaszwlod.virtualhr.service.PdfGenerator;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor

public class EmployeeController {
    private EmployeeService employeeService;



    @GetMapping
    public String getEmployees(Model model){
        model.addAttribute("employee",new Employee());
        List<Employee> employeesList = employeeService.getEmployees();
        model.addAttribute("employeesList",employeesList);


        return "employees";
    }

    @PostMapping
    public String addEmployee (@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    @RequestMapping(value="/edit",method = {RequestMethod.PUT,RequestMethod.GET})
    public String editEntry(@ModelAttribute Employee employee){
        employeeService.update(employee);
        return "redirect:/employees";
    }


    @GetMapping("/employee")
    public @ResponseBody Employee getOne(Long id) {
        return employeeService.getOne(id);
    }

    @RequestMapping(value="/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
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
