package com.myadream.app.qiyang.aop;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */


@RestController("test")
public class Test {

    private String test = "test";

    @GetMapping("/")
    public String test() {
        return this.test;
    }
}
