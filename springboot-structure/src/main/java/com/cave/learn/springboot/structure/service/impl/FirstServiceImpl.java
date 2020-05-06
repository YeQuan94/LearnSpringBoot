package com.cave.learn.springboot.structure.service.impl;

import com.cave.learn.springboot.structure.entity.FirstEntity;
import com.cave.learn.springboot.structure.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description: 第一个 Service 实现
 * @author: Cave
 * @create: 2020-04-29 17:51
 **/
@Service
public class FirstServiceImpl implements FirstService {

    @Autowired
    private FirstEntity defaultEntity;

    /**
     * @see FirstService#access(FirstEntity)
     */
    @Override
    public FirstEntity access(FirstEntity firstEntity) {
        if (StringUtils.isEmpty(firstEntity.getName())
                && StringUtils.isEmpty(firstEntity.getEmail())) {
            return defaultEntity;
        }

        if (!StringUtils.isEmpty(firstEntity.getEmail())) {
            firstEntity.setEmail(firstEntity.getEmail() + "@gmail.com");
        }
        return firstEntity;
    }

}
