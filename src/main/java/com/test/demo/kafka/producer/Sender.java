//package com.test.demo.kafka.producer;
//
//import com.test.demo.model.ZJModels;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Random;
//import java.util.UUID;
//
//
//@RestController
//@RequestMapping("/zj")
//public class Sender {
//
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    @RequestMapping("/kafka")
//    @ResponseBody
//    public void sendMessage(){
//        ZJModels m = new ZJModels();
//        m.setId(new Random().nextInt(10));
//        m.setName(UUID.randomUUID().toString());
//        m.setAge(new Random().nextInt());
//        kafkaTemplate.send("test1", m.toString());
//    }
//
//}
