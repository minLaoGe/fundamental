package com.minfengyu.day5;

public class TestStatic {
    static {
//        System.out.println(abc);
    }
    public  static  String abc="sdf";
    public static void main(String[] args) {
        System.out.println("sdf");
    }
    static {
        System.out.println(abc);
    }
}
