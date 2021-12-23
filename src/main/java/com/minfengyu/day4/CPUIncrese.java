package com.minfengyu.day4;

import com.minfengyu.entity.User;

public class CPUIncrese {
    public static final int initData=666;
    public static User user=new User();
    public int computer(){
        int a=1;
        int b=2;
        int c=(a+b)*10;
        return c;
    }
    public static void main(String[] args) {
        CPUIncrese cpuIncrese = new CPUIncrese();
        while (true){
            cpuIncrese.computer();
        }
    }
}
