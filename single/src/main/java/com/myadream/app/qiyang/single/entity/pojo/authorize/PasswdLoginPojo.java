package com.myadream.app.qiyang.single.entity.pojo.authorize;

import lombok.Data;

@Data
public class PasswdLoginPojo implements LoginPojo {
    private String account;

    private String password;

    private String code;
}
