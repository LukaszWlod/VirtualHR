package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Notice;
import com.githublukaszwlod.virtualhr.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImp implements NoticeService {
    private final NoticeRepository repository;

    @Autowired
    public NoticeServiceImp(NoticeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Notice notice) {
        repository.save(notice);

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public void updateNotice(Notice notice) {
        repository.save(notice);
    }

    @Override
    public List<Notice> getAllNotices() {
     return   repository.findAll();
    }
}
