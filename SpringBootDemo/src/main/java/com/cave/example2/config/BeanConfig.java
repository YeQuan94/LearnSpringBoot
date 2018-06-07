package com.cave.example2.config;

import com.cave.example2.dao.DemoDao;
import com.cave.example2.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration // 需要添加此注解Config类才能被SpringBoot加载，然后执行下面的@Bean注解
public class BeanConfig {

    @Bean
    public DemoDao getDemoDao(){
        DemoDao demoDao = new DemoDao();
        return demoDao;
    }

    @Bean( destroyMethod = "destoryDemoService")
    public DemoService getDemoService(){
        DemoService demoService = new DemoService();
        return demoService;
    }

}
