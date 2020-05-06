package com.cave.learn.springboot.structure.service;

import com.cave.learn.springboot.structure.entity.FirstEntity;

/**
 * @description: 第一个 Service
 * @author: Cave
 * @create: 2020-04-29 17:50
 **/
public interface FirstService {

    /**
     * 根据值构造
     *
     * @param firstEntity para
     * @return 查询结果
     */
    FirstEntity access(FirstEntity firstEntity);

}
