package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();
    void safeEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    void update(Employee employee);
    Employee getOne(Long id);

}
