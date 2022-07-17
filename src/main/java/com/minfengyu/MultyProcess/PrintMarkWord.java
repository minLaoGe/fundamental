package com.minfengyu.MultyProcess;

import com.google.gson.Gson;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PrintMarkWord {
    public static void main(String[] args) {
       /* Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());

        }*/
        String sbd="1233454354554624958";
        String s = new BigInteger(sbd, 10).toString(16).toUpperCase();
        System.out.println(s);
        String sb="{'jg':'sd苏打粉','sdf':'苏打粉'}";
        Map hashMap = new Gson().fromJson(sb, HashMap.class);
        System.out.println(hashMap);
    }
}
