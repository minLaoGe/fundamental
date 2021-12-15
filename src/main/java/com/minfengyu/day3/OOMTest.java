package com.minfengyu.day3;

import com.minfengyu.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {
    public static List<Object> list=new ArrayList<Object>();
    //JVM 设置
    public static  void main(String[] args){
        List<Object> list = new ArrayList<>();
        int i=0;
        int j=0;
        while (true){
            list.add(new User(i++, UUID.randomUUID().toString()));
        }
    }
}
