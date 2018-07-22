//package com.test.demo.service.impl;
//
//import com.test.demo.dao.ZJDao;
//import com.test.demo.model.ZJModels;
//import com.test.demo.service.ZJUserGetService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ZJUserGetServiceImpl implements ZJUserGetService {
//
//    @Autowired
//    private ZJDao zjDao;
//
//    @Override
//    public ZJModels getUserById(int id) {
//        return zjDao.getById(id);
//    }
//
//    @Override
//    public List<ZJModels> getUserByName(String name) {
//        return zjDao.getByName(name);
//    }
//
//    @Override
//    public List<ZJModels> getUserByAge(int age) {
//        return zjDao.getByAge(age);
//    }
//}
