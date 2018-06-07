package com.cave.example2.service;

import com.cave.example2.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public DemoService() {
        System.out.println("DemoService having be create.");
    }

//    @PreDestroy // 使用注解方式配置Destroy方法
    public void destoryDemoService(){
        System.out.println(demoDao + "_Maybe live");
    }
}
