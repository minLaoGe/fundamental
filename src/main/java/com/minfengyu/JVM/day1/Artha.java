package com.minfengyu.JVM.day1;

import java.util.HashSet;

public class Artha {
    private static HashSet hashSet = new HashSet();

    public static void main(String[] args) {
        // 模拟 CPU 过高
//        cpuHigh();
        // 模拟线程死锁
        deadThread();
        // 不断的向 hashSet 集合增加数据
//        addHashSetThread();
    }

    /**
     * 19 * 不断的向 hashSet 集合添加数据 20
     */

    public static void addHashSetThread() {
        // 初始化常量
        new Thread(() -> {
            int count = 0;
            while (true) {
                try {
                    hashSet.add("count" + count);
                    Thread.sleep(1000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void cpuHigh() {
        new Thread(() -> {
            while (true) {
            }
        }
        ).start();

    }

    private static void deadThread() {
        /** 创建资源 */
        Object resourceA = new Object();
        Object resourceB = new Object();
        // 创建线程
        Thread threadA = new Thread(()->{

            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " get ResourceA");
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                System.out.println(Thread.currentThread() + "waiting get resourceB");
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get resourceB");
                }
            }
        });
        Thread threadB = new Thread(()-> { synchronized (resourceB) {
            System.out.println(Thread.currentThread() + " get ResourceB");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread() + "waiting get resourceA");
            synchronized (resourceA) {
                System.out.println(Thread.currentThread() + " get resourceA");

            }
        }  });
        threadA.start();
        threadB.start();

    }
}
