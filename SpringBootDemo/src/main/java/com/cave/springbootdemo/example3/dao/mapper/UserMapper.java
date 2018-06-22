package com.cave.springbootdemo.example3.dao.mapper;

import com.cave.springbootdemo.example3.dao.utils.MyMapper;
import com.cave.springbootdemo.example3.pojo.User;

public interface UserMapper extends MyMapper<User> {

    /**
     * 多表查询，需要自己去编写SQL，同时加载XML文件
     *
     * @param user
     * @return
     */
    User login(User user);

}
