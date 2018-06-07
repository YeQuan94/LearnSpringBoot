package com.cave.example2.config;

import com.cave.example2.dao.DemoDao;
import com.cave.example2.service.DemoService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 需要添加此注解Config类才能被SpringBoot加载，然后执行下面的@Bean注解
public class BeanConfig {

    // 在Config中使用@Bean 和 在类上添加@Service @Repository 会重复，相当于创建两个对象
    // 同理，init 和 destroy 也一样，会执行两次

    @Bean
    public DemoDao getDemoDao(){
        DemoDao demoDao = new DemoDao();
        return demoDao;
    }

    // 查看@Bean源码可以发现一些基本属性的使用
    @Bean( destroyMethod = "destroyDemoService", initMethod = "initDemoService")
    public DemoService getDemoService(){
        DemoService demoService = new DemoService(this.getDemoDao());
        return demoService;
    }

}
