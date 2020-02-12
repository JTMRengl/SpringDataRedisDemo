package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右进
     */
    @Test
    public void setRight(){
        redisTemplate.boundListOps( "namelist1" ).rightPush( "刘备" );
        redisTemplate.boundListOps( "namelist1" ).rightPush( "关羽" );
        redisTemplate.boundListOps( "namelist1" ).rightPush( "张飞" );
    }

    @Test
    public void setLeft(){
        redisTemplate.boundListOps( "namelist2" ).leftPush( "刘备" );
        redisTemplate.boundListOps( "namelist2" ).leftPush( "关羽" );
        redisTemplate.boundListOps( "namelist2" ).leftPush( "张飞" );
    }

    /**
     * 取值
     */
    @Test
    public void getLeft(){
        System.out.println(redisTemplate.boundListOps( "namelist2" ).range( 0,10 ));
    }

    /**
     * 取值
     */
    @Test
    public void getRight(){
        System.out.println(redisTemplate.boundListOps( "namelist1" ).range( 0,10 ));
    }

    /**
     * 根据索引查询
     */
    @Test
    public void getByIndex(){
        System.out.println(redisTemplate.boundListOps( "namelist2" ).index( 1 ));
    }

    /**
     * 移除某个值,个数几个
     */
    @Test
    public void removeByname(){
        redisTemplate.boundListOps( "namelist1" ).remove( 2,"刘备" );
    }
}
