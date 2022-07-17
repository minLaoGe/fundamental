package com.minfengyu.cglib;

import com.minfengyu.common.ListNode;
import com.minfengyu.common.ProxyListNode;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
         System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"./");

         //实例化增强器
        Enhancer enhancer=new Enhancer();

        //设置需要道理的目标类
        enhancer.setSuperclass(ListNode.class);

        //设置拦截对象 回掉的是实现类
        enhancer.setCallback(new ProxyListNode());

        ListNode listNode = (ListNode) enhancer.create();
        System.out.println(listNode.getClass());
        listNode.sayHello();

    }
}
