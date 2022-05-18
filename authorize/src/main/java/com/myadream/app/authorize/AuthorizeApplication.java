package com.myadream.app.authorize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.myadream.app.authorize.dao")
public class AuthorizeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizeApplication.class, args);
    }
}
