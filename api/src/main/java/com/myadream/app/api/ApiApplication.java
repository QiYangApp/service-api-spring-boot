package com.myadream.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableTransactionManag

//@EntityScan(basePackages = "com.myadream.app.repository.*")
//@EntityScan(basePackages = "com.*")
//@ComponentScan(basePackages = "com.*")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
