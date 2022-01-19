package com.minfengyu.Day8;

import java.util.concurrent.ConcurrentLinkedQueue;

// simutite
public class CirculateDepence {

    private static ConcurrentLinkedQueue<Niochannel> con=new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<com.minfengyu.Day8.keyAttachment> keyAttachment=new ConcurrentLinkedQueue<>();

    static  E e=new E();
    public static void main(String[] args) {
        Niochannel channle = con.poll();
        String defaultStr="sdfsf";
        if (channle==null){
            channle = new Niochannel(defaultStr);
        }else {
            channle.setC(defaultStr);
        }
        e.getPoller9().regist(channle);
        System.out.println(con);
    }
}
