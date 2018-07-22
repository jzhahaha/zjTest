package com.test.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ZJMongoServiceTest {

    ZJMongoService zjMongoService = new ZJMongoService();

    @Test
    public void saveMongo() {
        zjMongoService.saveMongo();
    }
}