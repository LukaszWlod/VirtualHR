package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.LeaveDays;
import com.githublukaszwlod.virtualhr.repository.LeaveDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveDaysServiceImpl implements LeaveDaysService {



    LeaveDaysRepository leaveDaysRepository;

    @Autowired
    public LeaveDaysServiceImpl(LeaveDaysRepository leaveDaysRepository) {
        this.leaveDaysRepository = leaveDaysRepository;
    }

    @Override
    public LeaveDays getByEmployeeId(Long employeeId) {
        return leaveDaysRepository.findByEmployeeId(employeeId);
    }

    @Override
    public void save(LeaveDays leaveDays) {
        leaveDaysRepository.save(leaveDays);
    }

    @Override
    public void update(LeaveDays leaveDays) {
        leaveDaysRepository.save(leaveDays);
    }

    @Override
    public LeaveDays getById(Long id) {
        return leaveDaysRepository.findById(id).orElseThrow(()-> new RuntimeException("Element doesn't exist"));
    }
}
