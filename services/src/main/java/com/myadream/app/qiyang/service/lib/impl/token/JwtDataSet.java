package com.myadream.app.qiyang.service.lib.impl.token;

import io.jsonwebtoken.Claims;

public interface JwtDataSet {

    public Claims getClaims();

    public long getExpirationTime();

    public String getSecret();

}