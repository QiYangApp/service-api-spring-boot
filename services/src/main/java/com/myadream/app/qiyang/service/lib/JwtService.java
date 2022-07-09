package com.myadream.app.qiyang.service.lib;

import com.myadream.app.qiyang.service.lib.impl.token.JwtDataSet;

import java.util.Date;

public interface JwtService {
    /***
     * 生成token
     */
    public String generate(JwtDataSet jwtDataSet);

    /**
     * 移除token
     */
    public Boolean remove(String token);

    /**
     * 检查是否存在
     */
    public Boolean exist(String token);

    /**
     * 更新过期时间
     */
    public Boolean updateExpired(String token, Date date);

}
