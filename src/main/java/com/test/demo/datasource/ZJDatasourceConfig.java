//package com.test.demo.datasource;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.test.demo.dao.impl.JDBC" , sqlSessionFactoryRef = ZJDatasourceConfig.SQL_SESSION_FACTORY_NAME)
//public class ZJDatasourceConfig {
//
//    public static final String SQL_SESSION_FACTORY_NAME = "mpSessionFactory";
//
//    @Value("${spring.datasource.max-poolsize}")
//    private int maximumPoolSize;
//
//    @Value("${spring.datasource.connect-timeout-ms}")
//    private long connectTimeout;
//
//    @Value("${spring.datasource.validate-timeout-ms}")
//    private long validateTimeout;
//
//    @Value("${spring.datasource.zj.test1.url}")
//    private String test1Url;
//
//    @Value("${spring.datasource.zj.test1.username}")
//    private String test1Username;
//
//    @Value("${spring.datasource.zj.test1.password}")
//    private String test1Password;
//
////    @Value("${spring.datasource.zj.test2.url}")
////    private String test2Url;
////
////    @Value("${spring.datasource.zj.test2.username}")
////    private String test2Username;
////
////    @Value("${spring.datasource.zj.test2.password}")
////    private String test2Password;
//
//    @Bean(name = "test1HikariConfig")
//    public HikariConfig test1HikariConfig() {
//        HikariConfig conf = new HikariConfig();
//        conf.setJdbcUrl(test1Url);
//        conf.setUsername(test1Username);
//        conf.setPassword(test1Password);
//        conf.setPoolName("test1-table");
//        conf.setConnectionTimeout(connectTimeout);
//        conf.setValidationTimeout(validateTimeout);
//        conf.setMaximumPoolSize(maximumPoolSize);
//        return conf;
//    }
//
////    @Bean(name = "test2HikariConfig")
////    public HikariConfig test2HikariConfig() {
////        HikariConfig conf = new HikariConfig();
////        conf.setJdbcUrl(test2Url);
////        conf.setUsername(test2Username);
////        conf.setPassword(test2Password);
////        conf.setPoolName("test2-table");
////        conf.setConnectionTimeout(connectTimeout);
////        conf.setValidationTimeout(validateTimeout);
////        conf.setMaximumPoolSize(maximumPoolSize);
////        return conf;
////    }
//
//    @Bean(name = "test1DataSource")
//    public DataSource test1DataSource() {
//        return new HikariDataSource(test1HikariConfig());
//    }
//
////    @Bean(name = "test2DataSource")
////    public DataSource test2DataSource() {
////        return new HikariDataSource(test2HikariConfig());
////    }
//
////    @Bean(name = "sqltestDataSource")
////    public AbstractRoutingDataSource sqptestDataSource() {
////        DynamicDatasource dynamicDatasource = new DynamicDatasource();
////
////        Map<Object, Object> targetDataSources = new HashMap<>();
////        targetDataSources.put("test1", test1DataSource());
////        targetDataSources.put("test2", test1DataSource());
////        dynamicDatasource.setTargetDataSources(targetDataSources);
////
////        dynamicDatasource.afterPropertiesSet();
////        return dynamicDatasource;
////    }
//
//    /**
//     * 配置SqlSessionFactory：
//     * - 创建SqlSessionFactoryBean，并指定一个dataSource；
//     * - 指定mapper文件的路径；
//     */
//    @Bean(SQL_SESSION_FACTORY_NAME)
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(test1DataSource());
//
////        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sqlSessionFactoryBean.getObject();
//    }
//
//
//
//}
