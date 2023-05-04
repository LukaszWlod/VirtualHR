package com.githublukaszwlod.virtualhr.repository;

import com.githublukaszwlod.virtualhr.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
