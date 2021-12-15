package com.minfengyu.day3;

public class ThreadColorReamrkk {
    public static void main(String[] args) {
        A a = new A();
        //开始并发做标记
        D d=a.b.d;
        a.b.d=null;
        a.d=d;

    }
}
class A{
      B b=  new B();
        D d=null;
}
class  B{
       C c= new C();
       D d=new D();
}
class C{

}

class D{

}