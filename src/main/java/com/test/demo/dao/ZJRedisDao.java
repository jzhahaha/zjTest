package com.test.demo.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class ZJRedisDao<T> {

    private final static Logger log = LoggerFactory.getLogger(ZJRedisDao.class);

    private RedisTemplate<String , String> redisTemplate ;

    private ValueOperations<String , String> valueOps(){
        return redisTemplate.opsForValue();
    }

    public void storeValue(String key , T obj){
        valueOps().set(key , obj.toString());
    }

    public String findValue(String key){
        return valueOps().get(key);
    }


}
