//package com.test.demo.service.impl;
//
//import com.test.demo.service.QurartzService;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Service
//public class QurartzServiceImpl implements QurartzService {
//    private final static long TIME_GAP  = 5 * 1000;
//
//    @Override
//    @Scheduled(fixedRate = TIME_GAP)
//    public void timerToNow() {
//        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//    }
//}
