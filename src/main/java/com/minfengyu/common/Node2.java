package com.minfengyu.common;

import java.util.List;

public class Node2 {
    public int val;
    public Node2 next;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val, Node2 _next) {
        val = _val;
        next = _next;
    }
    public static Node2 composeNode2(List<Integer> list){
        Node2 node2 = new Node2(0);
        Node2 begin=node2;
        for (Integer integer : list) {
            node2.next=new Node2(integer);
            node2=node2.next;
        }
        node2.next=begin.next;
        return begin.next;
    }
}
