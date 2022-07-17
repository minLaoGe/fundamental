package com.minfengyu.MultyProcess;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Test7 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    private static Test7 cas = new Test7();
    private static volatile int state = 0;

    public static void main(String[] args) {
        new Thread(new Work(), "t-0").start();
        new Thread(new Work(), "t-1").start();
        new Thread(new Work(), "t-2").start();
        new Thread(new Work(), "t-3").start();
        new Thread(new Work(), "t-4").start();
    }


    static class Work implements Runnable {

        @Override
        public void run() {
            log.info("请求: {} 达到预定点，开始抢state;)", Thread.currentThread().getName());
            try {
                cyclicBarrier.await();
                ReentrantLock lock = new ReentrantLock();
                lock.lock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public final boolean compareAndSwapState(int oldvalue,int newvalue){
        return false;
    }
}
