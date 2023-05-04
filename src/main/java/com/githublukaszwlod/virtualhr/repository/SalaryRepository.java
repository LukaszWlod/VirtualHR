package com.githublukaszwlod.virtualhr.repository;

import com.githublukaszwlod.virtualhr.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {
    List<Salary> findByEmployeeId(Long employeeId);
}
