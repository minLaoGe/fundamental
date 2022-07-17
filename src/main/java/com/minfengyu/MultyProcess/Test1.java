package com.minfengyu.MultyProcess;

public class Test1 {
    public static volatile boolean str=true;
    public static void main(String[] args) {

        Thread t2 = new Thread(() -> {
            while (str) {

            }
            System.out.println("退出了" + Thread.currentThread().getName());
        }, "T2");

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            str = false;
        });
        t2.start();
        t1.start();

    }
}
