package com.cave.learn.springboot.structure.entity;

import java.io.Serializable;

/**
 * @description: entity
 * @author: Cave
 * @create: 2020-05-06 10:06
 **/
public class FirstEntity implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 邮件
     */
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
