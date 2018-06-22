package com.cave.springbootdemo.example4.service;

import com.cave.springbootdemo.example4.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findUserByNickName(String nickName);

}
