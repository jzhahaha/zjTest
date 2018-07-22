//package com.test.demo.kafka.consumer;
//
//import com.test.demo.model.ZJModels;
//import com.test.demo.util.JsonUtil;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Receiver {
//
//    @KafkaListener(topics = "test1")
//    public void processMessage(String content) {
//        try {
//            ZJModels m = JsonUtil.fromJson(content, ZJModels.class);
//            System.out.println(m);
//        }catch(Exception e){
//
//        }
//    }
//
//}