package com.githublukaszwlod.virtualhr.repository;

import com.githublukaszwlod.virtualhr.model.LeaveDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDaysRepository extends JpaRepository<LeaveDays,Long> {

    LeaveDays findByEmployeeId(Long employeeId);
}
