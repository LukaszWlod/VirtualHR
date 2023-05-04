package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Salary;
import com.githublukaszwlod.virtualhr.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImp implements  SalaryService {


    private final SalaryRepository salaryRepository;

   @Autowired
    public SalaryServiceImp(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Override
    public List<Salary> getSalary(Long employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }

    @Override
    public void safeSalary(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public void update(Salary salary) {
        salaryRepository.save(salary);
    }

    @Override
    public Salary getSalaryById(Long id) {
        Optional<Salary> salary = salaryRepository.findById(id);
        return salary.orElse(null);
    }
}
