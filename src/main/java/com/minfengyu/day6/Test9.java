package com.minfengyu.day6;

import java.util.ArrayList;

public class Test9 {
    static class ListNode {
        int val;
       ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {


        int[] ints = {4, 1, 8, 4, 5};
        int[] ints2 = {5, 6, 1, 8, 4, 5};

        ListNode listNode1 = setNodeList(ints);
        ListNode listNode2 = setNodeList(ints2);
        ListNode intersectionNode = getIntersectionNode(listNode1, listNode2);
        System.out.println(intersectionNode);
    }
    public static ListNode setNodeList(int[] arr){
        ListNode listNode = new ListNode(arr[0]);
        ListNode head=listNode;
        for (int i = 1; i < arr.length; i++) {
            listNode.next=new ListNode(arr[i]);
            listNode=listNode.next;
        }

        return head;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lentha=1;
        int lengthb=1;
        new ArrayList<>();
        if(headA==null||headB==null){
            return null;
        }
        ListNode headchainA=headA;
        ListNode headchainB=headB;
        while(headchainA.next!=null){
            lentha++;
            headchainA=headchainA.next;
        }
        while(headchainB.next!=null){
            lengthb++;
            headchainB=headchainB.next;
        }
        ListNode headNodeA=headA;
        ListNode headNodeB=headB;
        int num=0;
        if(lengthb>lentha){
            num= lengthb-lentha;
            while(0!=num--){
                headNodeB=headNodeB.next;
            }
        }else {
            num=lentha- lengthb;
            while(0!=num--){
                headNodeA=headNodeA.next;
            }
        }
        while(headNodeA!=headNodeB){
            headNodeB=headNodeB.next;
            headNodeA=headNodeA.next;
        }
        return headNodeA;
    }
}
