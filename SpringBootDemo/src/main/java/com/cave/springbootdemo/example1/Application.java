package com.cave.springbootdemo.example1;

import com.cave.springbootdemo.example1.student.StudentService;
import com.cave.springbootdemo.example1.student.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot简单Demo
 */
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.cave.example1.person"})
//@Configuration
@SpringBootApplication(scanBasePackages = "com.cave")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }
}
