package com.myadream.app.qiyang.service.token;

import com.myadream.app.qiyang.service.utils.jwt.JwtDataSet;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.Data;

import java.util.HashMap;

@Data
public class JwtDataSetImpl implements JwtDataSet {

    public String test;

    public JwtDataSetImpl(String t) {
        test = t;
    }

    @Override
    public Claims getClaims() {
       HashMap<String, Object> t = new HashMap<>(1);
      t.put("test", test);
        return new DefaultClaims(t);
    }

    @Override
    public long getExpirationTime() {
        return 36000;
    }

    @Override
    public String getSecret() {
        return "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    }
}
