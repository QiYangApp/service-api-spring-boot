package com.myadream.app.qiYang.entity.pojo.authorize;

import lombok.Data;

@Data
public class EmailLoginPojo implements LoginPojo {
    private String email;

    private String code;
}
