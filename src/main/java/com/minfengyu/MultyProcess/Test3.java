package com.minfengyu.MultyProcess;

public class Test3 {
    int a;
    int c;
    public volatile int m1=1;
    public volatile  int m2=2;
    public void readAndWrite(){
        int i=m1;//第一个volatile读
        int j=m2;//第二个volatiel读

        int c=2;//普通写
        a =i+j;//普通写

        m1=i+j; //第一个volatile写
        m2=j*2;//第二个volatile写
    }
}
