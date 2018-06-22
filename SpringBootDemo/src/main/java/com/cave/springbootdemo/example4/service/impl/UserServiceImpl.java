package com.cave.springbootdemo.example4.service.impl;

import com.cave.springbootdemo.example4.dao.mapper.UserMapper;
import com.cave.springbootdemo.example4.pojo.User;
import com.cave.springbootdemo.example4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByNickName(String nickName) {
        User userExample = new User();
        userExample.setNickname(nickName);
        List<User> select = userMapper.select(userExample);
        return select;
    }
}
