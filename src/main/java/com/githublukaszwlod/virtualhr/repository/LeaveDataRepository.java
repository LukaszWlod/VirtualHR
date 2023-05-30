package com.githublukaszwlod.virtualhr.repository;

import com.githublukaszwlod.virtualhr.model.LeaveData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveDataRepository extends JpaRepository<LeaveData,Long> {
    List<LeaveData> findByEmployeeId(Long employeeId);
}
