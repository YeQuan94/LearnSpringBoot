package com.cave.springbootdemo.example2.service;

import com.cave.springbootdemo.example2.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Service
public class DemoService {

    public DemoService(DemoDao demoDao) {
        this.demoDao = demoDao;
    }

    //    @Autowired
    private DemoDao demoDao;

    public DemoService() {
        System.out.println("DemoService having be create.");
    }

//    @PreDestroy // 使用注解方式配置Destroy方法
    public void destroyDemoService(){
        System.out.println(demoDao + "_Maybe live");
    }

//    @PostConstruct // 使用注解方式配置init方法
    public void initDemoService(){
        System.out.println("DemoService init.");
    }
}
