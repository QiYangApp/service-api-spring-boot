package com.myadream.app.qiyang.single.utils;

import com.myadream.app.qiyang.single.services.impl.token.JwtDataSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    public static String generate(JwtDataSet jwtDataSet) {
        return Jwts.builder()
                .setClaims(jwtDataSet.getClaims())
                .setExpiration(new Date(System.currentTimeMillis() + jwtDataSet.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, jwtDataSet.getSecret())
//                .signWith(SignatureAlgorithm.HS512, "")
                .compact();
    }
}
