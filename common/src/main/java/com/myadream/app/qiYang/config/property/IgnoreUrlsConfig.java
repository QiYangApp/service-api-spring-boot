package com.myadream.app.qiYang.config.property;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//@ConfigurationProperties(prefix = "secure.ignored")

@Data
@ConfigurationProperties(prefix = "secure.ignored")
//@PropertySource("classpath:application-security.yml")
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();
}
