//package com.test.demo.datasource;
//
//import com.test.demo.annotation.SqltestRepository;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@AutoConfigureAfter(ZJDatasourceConfig.class)
//public class MyBatisMapperScannerConfig {
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer1() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory1");
//        mapperScannerConfigurer.setBasePackage("com.test.demo.dao.impl.JDBC");
//        mapperScannerConfigurer.setAnnotationClass(SqltestRepository.class);
//        return mapperScannerConfigurer;
//    }
//}
