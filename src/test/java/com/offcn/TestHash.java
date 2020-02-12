package com.offcn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 添加
     */
    @Test
    public void addHash(){
        redisTemplate.boundHashOps( "content1" ).put( 1, "轮播第一张图片" );

        redisTemplate.boundHashOps( "content1" ).put( 2, "今日推荐第一张图片" );

        redisTemplate.boundHashOps( "content1" ).put( 3, "活动专区第一张图片" );
    }

    /**
     * 获取所有的key
     */
    @Test
    public void getKeys(){
        System.out.println(redisTemplate.boundHashOps( "content1" ).keys());
    }

    /**
     * 获取所有的值
     */
    @Test
    public void getValues(){
        System.out.println(redisTemplate.boundHashOps( "content1" ).values());
    }

    /**
     * 根据key来获取某一个
     */
    @Test
    public void getValueBykey(){
        //content1--大key  , 2--key
        System.out.println(redisTemplate.boundHashOps( "content1" ).get( 2 ));
    }

    /**
     * 根据key移除
     */
    @Test
    public void deleleValueBykey(){
        redisTemplate.boundHashOps( "content1" ).delete( 2 );
    }

    /**
     * 删除大key
     */
    @Test
    public void deleteBykey(){
        redisTemplate.delete( "content" );
    }
}
