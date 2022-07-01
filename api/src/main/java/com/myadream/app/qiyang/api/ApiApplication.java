package com.myadream.app.qiyang.api;


import com.myadream.app.qiyang.common.utils.I18nMessageUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ApiApplication {

    public ApiApplication(MessageSource messageSource) {
        I18nMessageUtil.setMessageSource(messageSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
