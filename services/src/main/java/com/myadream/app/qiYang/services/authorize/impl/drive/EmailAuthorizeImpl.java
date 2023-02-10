package com.myadream.app.qiYang.services.authorize.impl.drive;


import com.myadream.app.qiYang.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.RegisterPojo;
import com.myadream.app.qiYang.services.authorize.impl.AuthorizeOperationService;

public class EmailAuthorizeImpl implements AuthorizeOperationService {
    @Override
    public boolean login(LoginPojo loginPojo) {
        return false;
    }

    @Override
    public boolean register(RegisterPojo registerPojo) {
        return false;
    }
}
