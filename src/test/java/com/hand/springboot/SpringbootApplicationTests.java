package com.hand.springboot;

import com.hand.mapper.UserDemoMapper;
import com.hand.model.UserDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    /*@Test
    public void contextLoads() {
    }*/

    @Autowired
    private UserDemoMapper userDemoMapper;

    @Test
    public void test(){
        userDemoMapper.insert("周杰伦", "123456", "17018022508");
        /*UserDemo u = userDemoMapper.findUserByPhone("17018022508");
        Assert.assertEquals("周杰伦", u.getUserName());*/
    }

    @Test
    @Transactional
    public void testTransactional(){
        userDemoMapper.insert("张三", "123456", "18600000000");
        int a = 1/0;
        userDemoMapper.insert("李四", "123456", "13500000000");
        UserDemo u = userDemoMapper.findUserByPhone("12345678910");
        Assert.assertEquals("winterchen", u.getUserName());
    }

}
