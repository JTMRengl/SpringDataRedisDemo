package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 插入值
     */
    @Test
    public void setValue(){
        redisTemplate.boundValueOps( "ujiuye" ).set( "欢迎来到优就业" );
    }

    /**
     * 取值
     */
    @Test
    public void getValue(){
        String ujiuye = (String) redisTemplate.boundValueOps( "ujiuye" ).get();
        System.out.println(ujiuye);
    }

    /**
     * 删除
     */
    @Test
    public void deleteValue(){
        redisTemplate.delete( "ujiuye" );
    }
}
