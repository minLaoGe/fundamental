package com.minfengyu.day11;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Objects;

public class MyClassLoader extends ClassLoader {
    private String classpath;

    public MyClassLoader( String classpath) {
        this.classpath = classpath;
    }

    @SneakyThrows
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = null;
        try {
            if (name=="com.minfengyu.Day8.Poller"|| name.endsWith("keyAttachment")){

            }else {
                aClass = systemClassLoader.loadClass(name);
            }
        } catch (Exception e) {
            aClass=null;
        }
        if (Objects.isNull(aClass)) {
            byte[] bytes = loadByte(name);
            return defineClass(name,bytes,0,bytes.length);
        }
        return aClass;
    }
    private byte[] loadByte(String name)throws Exception
    {
        name = name.replace(".", "/");
        String finalPath = classpath + "/" + name + ".class";
        FileInputStream fis = new FileInputStream(finalPath);
        int len = fis.available();
        byte[] bytes = new byte[len];
        fis.read(bytes);
        fis.close();
        return bytes;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }


}

class Test {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/minfengyu/IdeaProjects/fundamental/target/classes");
        Class<?> aClass = myClassLoader.loadClass("com.minfengyu.Day8.Poller");
        Object poller =  aClass.newInstance();
        System.out.println(poller);
        System.out.println(aClass.getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}