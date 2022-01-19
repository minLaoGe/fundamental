package com.minfengyu.nio;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueListExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> strings = new ConcurrentLinkedQueue<>();
        strings.offer("sdf");
        System.out.println(strings.poll());
    }
}
class TestThread{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
