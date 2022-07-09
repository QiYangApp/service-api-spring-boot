package com.myadream.app.qiyang.api.controller;


import com.myadream.app.qiyang.service.entity.os.resp.RespEntity;
import com.myadream.app.qiyang.service.entity.os.resp.mode.ObjectMode;
import com.myadream.app.qiyang.service.lib.impl.token.JwtDataSetImpl;
import com.myadream.app.qiyang.service.lib.impl.token.JwtDataSet;
import com.myadream.app.qiyang.service.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */


@RestController("conf/test")
public class TestController {

    private String test = "conf/test";

    @GetMapping("/")
    public String test() {
        return this.test;
    }

    @GetMapping("/map")
    public HashMap<String, String> testMap() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("test", "conf/test");
        return map;
    }

    @GetMapping("/resp")
    public RespEntity testResp() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("test", "conf/test");
        return ObjectMode.success(map);
    }

    @GetMapping("/token")
    public String testToken() {
        JwtDataSet dataSet = new JwtDataSetImpl("conf/test");

        return (new JwtUtil()).generate(dataSet);
    }
}
