package com.myadream.app.qiyang.single.services.impl.authorize;

import com.myadream.app.qiyang.single.entity.pojo.authorize.LoginPojo;
import com.myadream.app.qiyang.single.entity.pojo.authorize.RegisterPojo;

public interface AuthorizeOperationService {

    boolean login(LoginPojo loginPojo);

    boolean register(RegisterPojo registerPojo);
}
