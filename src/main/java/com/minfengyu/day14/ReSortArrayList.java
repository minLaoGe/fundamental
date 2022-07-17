package com.minfengyu.day14;

import com.minfengyu.common.ListNode;

import java.util.Arrays;
import java.util.List;

public class ReSortArrayList {
    public static void main(String[] args) {
        ReSortArrayList reSortArrayList = new ReSortArrayList();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        ListNode listNode = ListNode.compostListNode(integers);
//        reSortArrayList.reorderList(listNode);

        ListNode listNode1 = reverseNodeList2(listNode);
        System.out.println(listNode1);

    }
    public static ListNode reverseNodeList2(ListNode head){
        ListNode pre=head;
        ListNode cur=head.next;
        head.next=null;

        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        return pre;
    }
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondly=slow.next;
        if(fast.next!=null){
            secondly=secondly.next;
        }
        slow=slow.next;
        slow.next=null;
        ListNode returnList=reverseNodeList(secondly);
        ListNode cur=head;
        while(cur!=null&&returnList!=null){
            ListNode middle=cur.next;
            cur.next=returnList;
            returnList=returnList.next;
            cur.next.next=middle;
            cur=middle;
        }

    }
    public ListNode reverseNodeList(ListNode listNode){
        ListNode pre=null;
        ListNode cur=listNode;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
