package com.myadream.app.qiyang.single.services;

import com.myadream.app.qiyang.single.services.impl.token.JwtDataSet;

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
    public Boolean updateExpired(String token, Long date);

    /**
     * 获取token数据
     * @return
     */
    public Object get(String token);

}
