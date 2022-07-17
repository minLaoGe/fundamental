package com.minfengyu.MultyProcess;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class Test6 {
    public static void main(String[] args) {
        Thread t0 = new Thread(new Runnable() {

            @Override
            public void run() {
                Thread thread = Thread.currentThread();
                log.info("{}，开始执行!", thread.getName());
                for (; ; ) {
                    log.info("准备park住线程:{} ...", thread.getName());
                    LockSupport.park();
                    log.info("丹铅线程{}已经被唤醒..", thread.getName());
                }
            }
        }, "to");
        t0.start();

        try {
            Thread.sleep(1000);
            log.info("准备唤醒{} 线程",t0.getName());
            LockSupport.unpark(t0);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
