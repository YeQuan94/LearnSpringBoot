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

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(String uid) {
        userMapper.deleteByPrimaryKey(uid);
    }
}
