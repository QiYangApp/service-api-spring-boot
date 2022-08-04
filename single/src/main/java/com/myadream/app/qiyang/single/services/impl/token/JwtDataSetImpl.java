package com.myadream.app.qiyang.single.services.impl.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

@Getter
public class JwtDataSetImpl implements JwtDataSet {
    public JwtDataSetImpl(HashMap<String, Object> data) {
        dataSet = data;
    }

    private Map<String, Object> dataSet;
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expires_second}")
    private Long timestamp;

    @Override
    public Claims getClaims() {
        return new DefaultClaims(dataSet);
    }

    @Override
    public long getExpirationTime() {
        return timestamp;
    }

    @Override
    public String getSecret() {
        return secret;
    }
}
