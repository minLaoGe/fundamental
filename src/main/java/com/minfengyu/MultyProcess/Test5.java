package com.minfengyu.MultyProcess;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {
    private static int total=0;
    private static Object object=new Object();

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    reentrantLock.lock();
                    for (int i1 = 0; i1 < 1000; i1++) {
                           total++;
                    }
                    reentrantLock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(500);
        countDownLatch.countDown();
        Thread.sleep(2000);
        System.out.println(total);

    }
}
