package com.test.demo.dao;

import com.test.demo.model.ZJModels;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ZJDao {

    void createUser(String name , Integer age , String area);

    void createUserByUser(ZJModels zjModels);

    List<ZJModels> getByName(String name);
    ZJModels getById(int id);
    List<ZJModels> getByAge(int age);

    ZJModels updateByUser(int id ,ZJModels zjModels);

    void updateByParm( String name , int age , String area , int id);

    void updateByMap(Map<String , Object> reqMap);

    void deleteByName(String name);

    List<ZJModels> selectAll();

}
