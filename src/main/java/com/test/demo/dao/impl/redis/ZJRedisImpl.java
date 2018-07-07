package com.test.demo.dao.impl.redis;

import com.test.demo.dao.ZJRedisDao;

public class ZJRedisImpl extends ZJRedisDao{
//    private final static String KEY_FORMAT = "zj"+id;

    public Object getById(Integer id){
        String keyFormat = "zj" + id;
        //先从缓存检查，没有再从数据库提取，然后写入缓存
        String value = findValue(keyFormat);
        if( null != value){

        }
        return  null;
    }

}
