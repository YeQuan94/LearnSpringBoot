package com.cave.springbootdemo.example5.test;

import com.cave.springbootdemo.example5.CacheApplication;
import com.cave.springbootdemo.example5.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = {CacheApplication.class}) // 通过classes指定运行哪个SpringBootApplication
public class CachaApplicationTests {

    @Resource( name = "getRedisTemplate" ) // Autowired注解会重新生成一个对象，因此需要使用Resource
    private RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    /**
     * HashOperations<H, HK, HV>
     *     H：hash值
     *     HK：hash key
     *     HV：hash value
     */
    @Test
    public void hashOperations(){
        HashOperations<String, String, Map<String, Object>> hashOperations = redisTemplate.opsForHash();
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setNickname("Jack");
        map.put("1", user);
        hashOperations.put("a", "user", map);
//        System.out.println(hashOperations.get("a", "user"));
    }

    // List Set ZSet

    /**
     * 向集合中添加一个document
     *
     * 当User类没有使用MongoDB注解标示时，需要在代码中手动声明
     */
    @Test
    public void mongoInsert(){
        User user = new User();
        user.setUsername("jack");
        user.setNickname("admin");
        mongoTemplate.insert(user, "users");
    }

    // 创建 | 修改 | 删除都比较简单，查询已经有了相关博客

    // MongoDB条件查询，相关资料
    // https://blog.csdn.net/congcong68/article/details/47183209

    /**
     * and条件查询
     */
    @Test
    public void mongoQueryAnd(){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("jack2").and("nickname").is("admin"));
        List<User> userList = mongoTemplate.find(query, User.class, "users");
        System.out.println(userList);
    }

    /**
     * or条件查询
     */
    @Test
    public void mongoQueryOr(){
        Query query = new Query();
        query.addCriteria(new Criteria().orOperator(Criteria.where("username").is("jack"), Criteria.where("nickname").is("jack")));
        List<User> userList = mongoTemplate.find(query, User.class, "users");
        System.out.println(userList);
    }

}
