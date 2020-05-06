package com.cave.learn.springboot.structure.config;

import com.cave.learn.springboot.structure.entity.FirstEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 实体类配置类
 * @author: Cave
 * @create: 2020-05-06 10:49
 **/
@Configuration
public class FirstBeanConfig {

    @Bean
    public FirstEntity getFirstEntity() {
        FirstEntity firstEntity = new FirstEntity();
        firstEntity.setName("default name");
        firstEntity.setEmail("default email");
        return firstEntity;
    }

}
