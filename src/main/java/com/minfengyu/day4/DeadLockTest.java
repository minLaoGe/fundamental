package com.minfengyu.day4;

import java.util.HashSet;
import java.util.Set;

public class DeadLockTest {
   private static  Object lock1=new Object();
    private static  Object lock2=new Object();
    private  static Set hasSet=new HashSet();
    public static void addHashSetThread(){
        new Thread(()->{
            int count=0;
            while (true){
                try {
                    hasSet.add("count"+count);
                    Thread.sleep(10000);
                    count++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock1){
                try {
                    System.out.println("thread1 begin");
                    Thread.sleep(5000);
                }catch (Exception e){

                }
                synchronized (lock2){
                    System.out.println("thred1 end");
                }
            }
        },"thread1").start();
        new Thread(()->{
            synchronized (lock2){
                try {
                    System.out.println("thread2 begin");
                    Thread.sleep(5000);
                }catch (Exception e){

                }
                synchronized (lock1){
                    System.out.println("thred2 end");
                }
            }
        },"thred2").start();

    }
}
