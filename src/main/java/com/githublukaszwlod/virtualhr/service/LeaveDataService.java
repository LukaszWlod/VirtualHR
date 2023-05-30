package com.githublukaszwlod.virtualhr.service;


import com.githublukaszwlod.virtualhr.model.LeaveData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaveDataService {
    void saveLeaveData(LeaveData leaveData);
    void updateLeaveData(LeaveData leaveData);
    void deleteById(Long id);
    List<LeaveData> getAllLeaveDataByEmployeeId(Long employeeId);

}
