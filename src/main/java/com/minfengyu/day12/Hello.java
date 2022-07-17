package com.minfengyu.day12;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Hello implements HelloMBean{
    private static final int DEFAULT_CACHE_SIZE=200;
    private final String name="reginald";
    private int cacheSize=DEFAULT_CACHE_SIZE;
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    @Override
    public int add(int x, int y) {
        return x+y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCacheSize() {
        return 1;
    }

    @Override
    public synchronized void setCacheSize(int size) {
        this.cacheSize=size;
        System.out.println("Cache size now"+this.cacheSize);
    }
}
class Main{
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example:type=Hello");
        Hello hello = new Hello();
        mbs.registerMBean(hello,name);

        System.out.println("Waiting forever....");
        Thread.sleep(Long.MAX_VALUE);
    }
}