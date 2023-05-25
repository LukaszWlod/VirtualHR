package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.LeaveDays;
import org.springframework.stereotype.Service;

@Service
public interface LeaveDaysService {
    LeaveDays getByEmployeeId(Long employeeId);
    void safe(LeaveDays leaveDays);
    void update(LeaveDays leaveDays);
    LeaveDays getById(Long id);
}
