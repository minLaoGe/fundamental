package com.minfengyu.day4;

import java.util.ArrayList;

public class ConstontPoolException {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            objects.add(i+"");
        }

    }

}