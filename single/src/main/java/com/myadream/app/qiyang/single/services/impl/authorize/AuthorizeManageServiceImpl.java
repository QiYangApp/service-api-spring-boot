package com.myadream.app.qiyang.single.services.impl.authorize;

import com.myadream.app.qiyang.single.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiyang.single.entity.pojo.authorize.RegisterPojo;
import com.myadream.app.qiyang.single.services.AuthorizeManageService;
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
