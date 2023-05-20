package com.githublukaszwlod.virtualhr.service;


import com.githublukaszwlod.virtualhr.model.Salary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SalaryService {

    List<Salary> getAllSalariesByEmployeeId(Long employeeId);
    void safeSalary(Salary salary);
    void update(Salary salary);
    Salary getSalaryById(Long id);
}
