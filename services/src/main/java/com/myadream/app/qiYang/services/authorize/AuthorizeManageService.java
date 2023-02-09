package com.myadream.app.qiYang.services.authorize;


import com.myadream.app.qiYang.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.RegisterPojo;

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
