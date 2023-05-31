package com.githublukaszwlod.virtualhr.service;

import com.githublukaszwlod.virtualhr.model.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {
    void save(Notice notice);
    void deleteById(Long id);
    void updateNotice(Notice notice);

    List<Notice> getAllNotices();

}
