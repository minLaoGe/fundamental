package com.minfengyu.day9;

import java.util.Arrays;

public class TestArrayCopy {
    public static void main(String[] args) {
        byte[] origin = {12, 3, 4, 5,2,3,4,};
        byte[] newOne=new byte[20];
        System.arraycopy(origin,0,newOne,4,Math.min(origin.length,newOne.length));
        System.out.println(Arrays.toString(newOne));
    }
}
