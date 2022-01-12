package com.minfengyu.entity;

public class User extends Person {
    private final byte[] a=new byte[23];
    private Integer age=0;
    private String name="sdf";

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
