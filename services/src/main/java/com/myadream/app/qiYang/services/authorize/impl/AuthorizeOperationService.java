package com.myadream.app.qiYang.services.authorize.impl;


import com.myadream.app.qiYang.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.RegisterPojo;

public interface AuthorizeOperationService {

    boolean login(LoginPojo loginPojo);

    boolean register(RegisterPojo registerPojo);
}
