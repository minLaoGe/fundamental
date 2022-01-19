package com.minfengyu.day11;

import lombok.SneakyThrows;

public class TestTomcatLock {
    @SneakyThrows
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.minfengyu.entity.Person");
        System.out.println(aClass);
    }
}
