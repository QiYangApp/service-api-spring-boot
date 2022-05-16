package com.myadream.app.authorize.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wqlm.boot.user.dao")
public class AuthorizeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorizeApplication.class, args);
    }
}
