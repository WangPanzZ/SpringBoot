package com.hand.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WangPan
 * @title RedisCacheTests
 * @description (描述此类的功能)
 * @date: 2018/5/21 15:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisCacheTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void stringTest(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello", "redis");
        System.out.println("useRedisDao = " + valueOperations.get("hello"));
    }
}
