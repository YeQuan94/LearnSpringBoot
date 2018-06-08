package com.cave.example3.test;

import com.cave.example3.MyBatisApplication;
import com.cave.example3.dao.mapper.UserMapper;
import com.cave.example3.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {MyBatisApplication.class}) // 通过classes指定运行哪个SpringBootApplication
public class MyBatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

}
