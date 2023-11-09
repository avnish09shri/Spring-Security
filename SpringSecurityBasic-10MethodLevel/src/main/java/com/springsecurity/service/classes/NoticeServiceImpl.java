package com.springsecurity.service.classes;

import com.springsecurity.model.Notice;
import com.springsecurity.repository.NoticeRepository;
import com.springsecurity.service.interfaces.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> findAllNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
