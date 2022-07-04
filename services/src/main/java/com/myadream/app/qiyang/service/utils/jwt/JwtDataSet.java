package com.myadream.app.qiyang.service.utils.jwt;

import io.jsonwebtoken.Claims;

public interface JwtDataSet {

    public Claims getClaims();

    public long getExpirationTime();

    public String getSecret();

}
