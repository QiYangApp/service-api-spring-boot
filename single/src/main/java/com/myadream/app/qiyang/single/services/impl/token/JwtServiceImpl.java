package com.myadream.app.qiyang.single.services.impl.token;

import com.myadream.app.qiyang.single.services.JwtService;
import com.myadream.app.qiyang.single.utils.JwtUtil;
import com.myadream.app.qiyang.single.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String generate(JwtDataSet jwtDataSet) {
        String token = JwtUtil.generate(jwtDataSet);

        String base64Token = Base64.getEncoder().encodeToString(token.getBytes());

        redisUtil.set(base64Token, token, 3600);

        return base64Token;
    }

    @Override
    public Boolean remove(String token) {
        return redisUtil.del(token);
    }

    @Override
    public Boolean exist(String token) {
        return redisUtil.hasKey(token);
    }

    @Override
    public Boolean updateExpired(String token, Long date) {
        return redisUtil.expire(token, date);
    }

    @Override
    public Object get(String token) {
        return redisUtil.get(token);
    }
}
