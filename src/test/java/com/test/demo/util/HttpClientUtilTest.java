package com.test.demo.util;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class HttpClientUtilTest {

    @Test
    public void postAsync() {
        try {
            HttpClientUtil test = new HttpClientUtil();
            Map<String , String> param = new HashMap<String, String>() ;
            param.put("title" , "test");
            param.put("content" , "test");
            param.put("toEmail" , "249358019@qq.com");
//            test.postAsync("http://localhost:8080/email",param);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}