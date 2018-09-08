package com.cave.springbootdemo.example6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Lucene7
 */
@SpringBootApplication
@MapperScan( basePackages = {"com.cave.springbootdemo.example6.dao.mapper"})
public class LuceneApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuceneApplication.class, args);
    }

}
