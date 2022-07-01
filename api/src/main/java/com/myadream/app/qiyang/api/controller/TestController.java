package com.myadream.app.qiyang.api.controller;


import com.myadream.app.qiyang.common.api.RespEntity;
import com.myadream.app.qiyang.common.api.mode.DefaultMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */


@RestController("test")
public class TestController {

    private String test = "test";

    @GetMapping("/")
    public String test() {
        return this.test;
    }

    @GetMapping("/map")
    public HashMap<String, String> testMap() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("test", "test");
        return map;
    }

    @GetMapping("/resp")
    public RespEntity testResp() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("test", "test");
        return (new DefaultMode<Map<String, String>>()).success(map);
    }
}
