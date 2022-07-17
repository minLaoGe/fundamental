package com.minfengyu.day11;

import lombok.SneakyThrows;

public class TestTomcatLock {
    @SneakyThrows
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.minfengyu.entity.Person");
        System.out.println(aClass);

        byte sd=-127;
        System.out.println(sd&0xffff);
    }
}
