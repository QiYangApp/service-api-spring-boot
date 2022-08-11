package com.myadream.app.qiyang.single.listener;

import com.myadream.app.qiyang.single.event.AuthorizeEvent;
import com.myadream.app.qiyang.single.services.AuthorizeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

@Slf4j
public class AuthorizeRecordListener implements ApplicationListener<AuthorizeEvent> {

    @Autowired
    private AuthorizeRecordService authorizeRecordService;

    @Async
    @Override
    public void onApplicationEvent(AuthorizeEvent event) {
        log.info("authorize record event listener {}", event.getAuthorizedPo());

        authorizeRecordService.authorize(event.getAuthorizedPo());

    }
}
