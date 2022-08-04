package com.myadream.app.qiyang.single.services;

import com.myadream.app.qiyang.single.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiyang.single.entity.pojo.authorize.RegisterPojo;

public interface AuthorizeManageService {
    /**
     * 登录
     */
    boolean login(LoginPojo loginPojo);

    /**
     * 注册
     */
    boolean register(RegisterPojo registerPojo);
}
