package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestSet {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 添加
     */
    @Test
    public void setValue(){
        redisTemplate.boundSetOps( "三国" ).add( "关羽" );
        redisTemplate.boundSetOps( "三国" ).add( "张飞" );
        redisTemplate.boundSetOps( "三国" ).add( "刘备" );
    }

    /**
     * 取值
     */
    @Test
    public void getValue(){
        System.out.println(redisTemplate.boundSetOps( "三国" ).members());
    }

    /**
     * 删除某一个值
     */
    @Test
    public void deleteValueOne(){
        redisTemplate.boundSetOps( "三国" ).remove( "刘备" );
    }

    /**
     * 删除整个set
     */
    @Test
    public void deleteAll(){
        redisTemplate.delete( "三国" );
    }
}
