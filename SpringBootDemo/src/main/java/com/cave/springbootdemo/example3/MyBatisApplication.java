package com.cave.springbootdemo.example3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot + MyBatis
 */
@SpringBootApplication
@MapperScan( basePackages = {"com.cave.springbootdemo.example3.dao.mapper"})
// 需要使用tk.mybatis的MapperSacn
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class, args);
    }

}
