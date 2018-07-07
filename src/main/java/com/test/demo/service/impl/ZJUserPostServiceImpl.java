package com.test.demo.service.impl;

import com.test.demo.dao.ZJDao;
import com.test.demo.model.ZJModels;
import com.test.demo.service.ZJUserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ZJUserPostServiceImpl implements ZJUserPostService {

    @Autowired
    ZJDao zjDao;


    @Override
    public void createUserByPara(String name, int age, String area) {
        zjDao.createUser(name , age , area);
    }

    @Override
    public void createUserByUser(ZJModels zjModels){
        zjDao.createUserByUser(zjModels);
    }

    @Override
    public ZJModels updateByUser(int id ,ZJModels zjModels) {
        return zjDao.updateByUser(id,zjModels);
    }

    @Override
    public void updateByParm(int id,String name,int age ,String area){
        zjDao.updateByParm( name , age , area , id);
    }

    @Override
    public void updateByMap(int id, Map<String, Object> reqMap) {
        zjDao.updateByMap(reqMap);
    }
}
