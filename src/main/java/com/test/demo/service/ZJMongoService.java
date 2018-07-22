package com.test.demo.service;

import com.test.demo.dao.impl.mongo.ZJMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZJMongoService {

    @Autowired
    ZJMongo zjMongo = new ZJMongo();

    public void saveMongo(){
        zjMongo.createUser("name",39 ,"ads");
    }
}
