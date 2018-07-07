package com.test.demo.model;

public class ZJModels {

    private  int id;
    private String name;
    private int age;
    private String area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "name:"+name
                +",age:"+age
                +",area:"+area;
    }

}



//    CREATE TABLE zjtest(
//        id INT(10) not null  auto_increment,
//        name VARCHAR(30) not null ,
//        age int(30) not null,
//        area VARCHAR(50) not null,
//        PRIMARY key(id)
//        )ENGINE=INNODB  auto_increment=10 DEFAULT charset=utf8