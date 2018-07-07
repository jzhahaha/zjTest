package com.test.demo.dao.impl.JDBC;

import com.test.demo.dao.ZJDao;
import com.test.demo.model.ZJModels;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ZJDaoMapper extends ZJDao {

    @Override
    @Insert("insert into sqltest.zjtest(name,age,area) values(#{name},#{age},#{area})")
    void createUser(@Param("name") String name , @Param("age") Integer age , @Param("area") String area);

    @Override
    @Insert("insert into sqltest.zjtest(name,age,area) values(#{name},#{age},#{area})")
    void createUserByUser(ZJModels zjModels);


    @Override
    @Select("select * from sqltest.zjtest where name= #{name}")
    List<ZJModels> getByName(@Param("name") String name);

    @Override
    @Select("select * from sqltest.zjtest where id= #{id}")
    ZJModels getById(@Param("id") int id);

    @Override
    @Select("select * from sqltest.zjtest where age= #{age}")
    List<ZJModels> getByAge(@Param("age") int age);

    @Override
    @Update("update sqltest.zjtest set name=#{name} , age=#{age} , area=#{area} where id=#{id}")
    ZJModels updateByUser(@Param("id")int id, ZJModels zjModels);

    @Override
    @Update("update sqltest.zjtest set name=#{name} , age=#{age} , area=#{area} where id=#{id}")
    void updateByParm( @Param("name")String name,@Param("age")int age ,@Param("area")String area , @Param("id")int id);

    @Override
    @Delete("delete from sqltest.zjtest where name=#{name}")
    void deleteByName(@Param("name") String name);

    @Override
    @Update("update sqltest.zjtest set name=#{name} , age=#{age} , area=#{area} where id=#{id}")
    void updateByMap(Map<String, Object> reqMap);

    @Override
    @Select("select * from sqltest.zjtest")
    List<ZJModels> selectAll();
}
