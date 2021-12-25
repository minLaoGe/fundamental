package com.minfengyu.JVM.day1;

public class ReWriteClassLoader {
        static class  MyClassLoader extends ClassLoader{
            private String classPath;
                public MyClassLoader(String classPath){
                    this.classPath=classPath;

                }

            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                Class<?> c = findLoadedClass(name);
                return null;
            }
        }
}
