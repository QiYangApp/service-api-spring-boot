package com.myadream.app.qiyang.single.services.impl.authorize.drive;

import com.myadream.app.qiyang.single.entity.pojo.authorize.EmailLoginPojo;
import com.myadream.app.qiyang.single.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiyang.single.entity.pojo.authorize.RegisterPojo;
import com.myadream.app.qiyang.single.services.impl.authorize.AuthorizeOperationService;

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
