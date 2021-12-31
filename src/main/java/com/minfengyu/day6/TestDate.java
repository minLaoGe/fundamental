package com.minfengyu.day6;

import com.minfengyu.entity.User;

import java.util.ArrayList;
import java.util.List;

public class TestDate {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList();
        while (true){
            list.add(new User());
            Thread.sleep(3000);
        }
    }
}
