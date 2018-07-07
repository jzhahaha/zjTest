package com.test.demo.service;

import com.test.demo.model.ZJModels;

import java.util.Map;

public interface ZJUserPostService {
    void createUserByPara(String name , int age , String area);

    void createUserByUser(ZJModels zjModels);

    ZJModels updateByUser(int id ,ZJModels zjModels);

    void updateByParm(int id , String name , int age , String area);

    void updateByMap(int id ,Map<String , Object> reqMap);
}
