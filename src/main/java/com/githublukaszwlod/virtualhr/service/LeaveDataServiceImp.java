package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.LeaveData;
import com.githublukaszwlod.virtualhr.repository.LeaveDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveDataServiceImp implements LeaveDataService {
    LeaveDataRepository repository;

    @Autowired
    public LeaveDataServiceImp(LeaveDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveLeaveData(LeaveData leaveData) {
        repository.save(leaveData);
    }

    @Override
    public void updateLeaveData(LeaveData leaveData) {
        repository.save(leaveData);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<LeaveData> getAllLeaveDataByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}
