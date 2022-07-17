package com.minfengyu.day15;

import com.minfengyu.common.ListNode;
import com.minfengyu.common.Node;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Day15 {
    public static void main(String[] args) {
        Node[] node1=new Node[3];
        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        for (int i = 0; i < node1.length; i++) {
            Node x=node1[i];
            System.out.println(x);
        }
    }
        public boolean isPalindrome(ListNode head) {
            ListNode slow=head;
            ListNode fast=head;
            while(fast.next!=null&&fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode oneNode=slow.next;
            slow.next=null;
            ListNode newNode=reverseNodeList(oneNode);
            while(newNode!=null){
                if(head.val!=newNode.val){
                    return false;
                }
                newNode=newNode.next;
                head=head.next;
            }
            return true;
        }

        public ListNode reverseNodeList(ListNode head){
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
}
