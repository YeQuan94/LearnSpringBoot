package com.cave.learn.springboot.structure.controller;

import com.cave.learn.springboot.structure.entity.FirstEntity;
import com.cave.learn.springboot.structure.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 第一个 Controller
 * @author: Cave
 * @create: 2020-04-29 16:26
 **/
@RestController
@RequestMapping("/first")
public class FirstController {

    @Autowired
    private FirstService firstService;

    /**
     * helloWorld
     *
     * @return 响应结果
     */
    @GetMapping("/helloWorld")
    public Object helloWorld() {
        return "helloWorld";
    }

    /**
     * 参数赋值
     *
     * @param firstEntity para
     * @return 响应结果
     */
    @GetMapping("/access")
    public Object access(FirstEntity firstEntity) {
        return firstService.access(firstEntity);
    }

}
