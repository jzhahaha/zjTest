package com.test.demo.service.impl;

import com.test.demo.dao.ZJDao;
import com.test.demo.model.ZJModels;
import com.test.demo.service.DbToExcel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
@Service
public class DbToExcelImpl implements DbToExcel {

    @Autowired
    ZJDao zjDao;
    @Override
    public void getAll() {
        try{
            List<ZJModels> zjtest = zjDao.selectAll();
            File exportFile = new File("F:\\IDEA\\ZJTest1","exportTest.xls");
            FileOutputStream out = new FileOutputStream(exportFile);

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("asd");


            int rowIndex = 0;
            for(ZJModels zj : zjtest){
                Row row = sheet.createRow(rowIndex);
                row.createCell(0).setCellValue(zj.getName());
                row.createCell(1).setCellValue(zj.getAge());
                row.createCell(2).setCellValue(zj.getArea());
                rowIndex++;
            }

            workbook.write(out);
            out.flush();
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
