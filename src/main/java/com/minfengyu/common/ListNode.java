package com.minfengyu.common;

import java.util.Collection;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode  compostListNode(Collection<Integer> collection){
        if (collection.size()<1){
            return null;
        }
        ListNode listNode = new ListNode(0);
        ListNode head=listNode;
        for (Integer integer : collection) {
            listNode.next=new ListNode(integer);
            listNode=listNode.next;
        }
        return  head.next;
    }
    public void sayHello(){
        System.out.println("hello");
    }
}
