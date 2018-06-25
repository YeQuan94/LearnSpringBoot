package com.cave.springbootdemo.example5.test;

import com.cave.springbootdemo.example5.CacheApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {CacheApplication.class}) // 通过classes指定运行哪个SpringBootApplication
public class CachaApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    // RedisTemplate相关操作
    // https://blog.csdn.net/fengyao1995/article/details/72794899

    @Test
    public void add(){
        redisTemplate.opsForValue().set("1", "2");
    }
}
