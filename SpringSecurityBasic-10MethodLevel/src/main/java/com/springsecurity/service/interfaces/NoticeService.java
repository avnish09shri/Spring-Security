package com.springsecurity.service.interfaces;

import com.springsecurity.model.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> findAllNotices();
}
