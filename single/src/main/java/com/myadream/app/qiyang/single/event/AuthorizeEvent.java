package com.myadream.app.qiyang.single.event;

import com.myadream.app.qiyang.single.entity.po.authorize.AuthorizedPo;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;


public class AuthorizeEvent extends ApplicationEvent {

    private AuthorizedPo authorizedPo;

    public AuthorizeEvent(Object source) {
        super(source);
    }

    public AuthorizeEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
