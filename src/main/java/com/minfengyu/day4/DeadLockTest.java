package com.minfengyu.day4;

public class DeadLockTest {
   private static  Object lock1=new Object();
    private static  Object lock2=new Object();

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
