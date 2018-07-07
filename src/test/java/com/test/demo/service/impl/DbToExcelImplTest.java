package com.test.demo.service.impl;

import com.test.demo.model.ZJModels;
import com.test.demo.service.DbToExcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DbToExcelImplTest {

    @Autowired
    DbToExcel dbToExcel;

    @Test
    public void getAll() {
        dbToExcel.getAll();

    }
}