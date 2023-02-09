package com.myadream.app.qiYang.services.authorize.impl;

import com.myadream.app.qiYang.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiYang.entity.pojo.authorize.RegisterPojo;
import com.myadream.app.qiYang.services.authorize.AuthorizeManageService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeManageServiceImpl implements AuthorizeManageService {
    private AuthorizeOperationService authorizeOperationService;

    public AuthorizeManageService setType(AuthorizeOperationService authorizeOperationService) {
        this.authorizeOperationService = authorizeOperationService;
        return this;
    }

    @Override
    public boolean login(LoginPojo loginPojo) {
        return this.authorizeOperationService.login(loginPojo);
    }

    @Override
    public boolean register(RegisterPojo registerPojo) {
        return this.authorizeOperationService.register(registerPojo);
    }
}
