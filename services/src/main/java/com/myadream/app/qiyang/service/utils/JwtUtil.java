package com.myadream.app.qiyang.service.utils;

import com.myadream.app.qiyang.service.lib.JwtService;
import com.myadream.app.qiyang.service.lib.impl.token.JwtDataSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Base64;
import java.util.Date;

public class JwtUtil implements JwtService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public String generate(JwtDataSet jwtDataSet) {
        String token = Jwts.builder()
                .setClaims(jwtDataSet.getClaims())
                .setExpiration(new Date(System.currentTimeMillis() + jwtDataSet.getExpirationTime()))
//                .signWith(SignatureAlgorithm.HS512, jwtDataSet.getSecret())
                .signWith(SignatureAlgorithm.HS512, "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=")
                .compact();

        String base64Token = Base64.getEncoder().encodeToString(token.getBytes());

        redisTemplate.opsForValue().set(base64Token, token);

        return base64Token;
    }

    @Override
    public Boolean remove(String token) {
        return redisTemplate.delete(token);
    }

    @Override
    public Boolean exist(String token) {
        return redisTemplate.hasKey(token);
    }

    @Override
    public Boolean updateExpired(String token, Date date) {
        return redisTemplate.expireAt(token, date);
    }
}
