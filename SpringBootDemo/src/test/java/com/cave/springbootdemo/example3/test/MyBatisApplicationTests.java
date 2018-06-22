package com.cave.springbootdemo.example3.test;

import com.cave.springbootdemo.example3.MyBatisApplication;
import com.cave.springbootdemo.example3.dao.mapper.UserMapper;
import com.cave.springbootdemo.example3.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {MyBatisApplication.class}) // 通过classes指定运行哪个SpringBootApplication
public class MyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有
     */
    @Test
    public void selectAll(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

    /**
     * 条件查询 使用"等于"比较
     */
    @Test
    public void select(){
        User userExample = new User();
        userExample.setUid(2);
        userExample.setNickname("超级管理员");
        List<User> users = userMapper.select(userExample);
        System.out.println(users);
    }

    /**
     * 通用Mapper的Example条件查询
     */
    @Test
    public void selectByExample(){
        Example example = new Example(User.class);
        Example.Criteria likeNickName = example.and();
        likeNickName.andEqualTo("uid", "2");
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);
    }

    // INSERT | UPDATE | DELETE 这三种SQL比较简单就不再写Demo了

    @Test
    public void login(){
        User userExample = new User();
        userExample.setUsername("admin");
        userExample.setPassword("admin");
        User user = userMapper.login(userExample);
        System.out.println(user);
    }

}
