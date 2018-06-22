package com.cave.springbootdemo.example4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot + RESTful + SpringMVC
 */
@SpringBootApplication( scanBasePackages = {"com.cave.springbootdemo.example4"}) // 如果Application类放在Root目录上，就不用加这个属性
@MapperScan( basePackages = "com.cave.springbootdemo.example4.dao.mapper") // 需要扫描到mapper包下，不要包含MyMapper
public class RESTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RESTfulApplication.class, args);
    }

}
