package com.springsecurity.controller;

import com.springsecurity.model.Notice;
import com.springsecurity.service.classes.NoticeServiceImpl;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    private final NoticeServiceImpl noticeServiceImpl;

    public NoticesController(NoticeServiceImpl noticeServiceImpl) {
        this.noticeServiceImpl = noticeServiceImpl;
    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> allNotices = noticeServiceImpl.findAllNotices();
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(allNotices);
    }

}
