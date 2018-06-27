package com.cave.springbootdemo.example5.test;

import com.cave.springbootdemo.example5.CacheApplication;
import com.cave.springbootdemo.example5.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {CacheApplication.class}) // 通过classes指定运行哪个SpringBootApplication
public class CachaApplicationTests {

    @Resource( name = "getRedisTemplate" ) // Autowired注解会重新生成一个对象，因此需要使用Resource
    private RedisTemplate redisTemplate;

    // RedisTemplate相关操作
    // https://blog.csdn.net/fengyao1995/article/details/72794899
    // 需要有超时时间设置

    /**
     * 操作Redis String类型数据
     *
     * 如果是操作String类型的，最好使用StringRedisTemplate
     */
    @Test
    public void valueOperations(){
        // 获取ValueOperations操作对象
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 普通set方法
        valueOperations.set("21231", "2");
        // 设置set方法超时时间，TimeUnit是时间单位，时分秒等等
//        valueOperations.set("2", "3", 10, TimeUnit.SECONDS); // 超时时间为10秒
        // 删除
//        redisTemplate.delete("1");
    }

    /**
     * Key = String, Value = Object
     *
     */
    @Test
    public void valueOperationsObject(){
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        User user = new User();
        user.setUid(1);
        valueOperations.set("1", user);
        System.out.println(valueOperations.get("1"));
    }

}
