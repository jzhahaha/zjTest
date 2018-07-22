package com.test.demo.dao.impl.mongo;

import com.test.demo.dao.ZJDao;
import com.test.demo.model.ZJModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ZJMongo  {

    @Autowired
    private MongoTemplate mongoTemplate = new MongoTemplate();

//    @Override
    public void createUser(String name, Integer age, String area) {
        ZJModels zjModels = new ZJModels();
        zjModels.setAge(age);
        zjModels.setName(name);
        zjModels.setArea(area);
        mongoTemplate.insert(zjModels);
    }

//    @Override
    public void createUserByUser(ZJModels zjModels) {

    }

//    @Override
    public List<ZJModels> getByName(String name) {
        return null;
    }

//    @Override
    public ZJModels getById(int id) {
        return null;
    }

//    @Override
    public List<ZJModels> getByAge(int age) {
        return null;
    }

//    @Override
    public ZJModels updateByUser(int id, ZJModels zjModels) {
        return null;
    }

//    @Override
    public void updateByParm(String name, int age, String area, int id) {

    }

//    @Override
    public void updateByMap(Map<String, Object> reqMap) {

    }

//    @Override
    public void deleteByName(String name) {

    }

//    @Override
    public List<ZJModels> selectAll() {
        return null;
    }
}
