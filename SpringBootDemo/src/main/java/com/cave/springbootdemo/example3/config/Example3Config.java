package com.cave.springbootdemo.example3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 添加以后才能被扫描到
@ConfigurationProperties(prefix = "example3")
@Profile({"example3"}) // 如果加载多个application-{profile}.properties
// （locations在springboot 1.5版后已去掉了，
// 可将配置移到application.properties或application-{profile}.properties中）
public class Example3Config {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
