package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Employee;
import com.githublukaszwlod.virtualhr.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements  EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void safeEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }



}
