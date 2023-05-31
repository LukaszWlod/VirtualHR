package com.githublukaszwlod.virtualhr.controller;

import com.githublukaszwlod.virtualhr.model.Notice;
import com.githublukaszwlod.virtualhr.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoticeController {
    private final NoticeService noticeService;

   @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String getNoticePage(Model model) {
        List<Notice> notices = noticeService.getAllNotices();

        model.addAttribute("notices", notices);

        return "notice";
    }
}
