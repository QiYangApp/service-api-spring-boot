package com.myadream.app.qiyang.single.event;

import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;


@Slf4j
public class AuthorizeEvent extends ApplicationEvent {

    @Getter
    private AuthorizedPo authorizedPo;

    public AuthorizeEvent(AuthorizedPo authorizedPo) {
        super(authorizedPo);
        this.authorizedPo = authorizedPo;
        log.info("add event success! message: {}", authorizedPo);
    }

    public AuthorizeEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
