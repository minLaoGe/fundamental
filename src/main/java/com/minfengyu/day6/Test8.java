package com.minfengyu.day6;

public class Test8 {
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }

    public static void main(String[] args) {
      String    string="苏打粉苏打粉";

    }

    private static void extracted() {
        ListNode listNode = new ListNode(3);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(0);
        listNode.next.next.next=new ListNode(-4);
        listNode.next.next.next.next=listNode.next;
        Test8 test8 = new Test8();

        System.out.println( test8.detectCycle(listNode));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode au=getLoopNode(head);
        if(null==au){
            return au;
        }
        ListNode fast=au;
        int count=0;
        for(ListNode init=fast.next;fast!=init;init=init.next){
            count++;
        }
        ListNode slow=head;
        ListNode fast2=head.next;
        for (int i = 0; i < count; i++) {
            fast2=fast2.next;
        }
        while(slow!=fast2){
            slow=slow.next;
            fast2=fast2.next;
        }
        return slow;
    }
    public ListNode getLoopNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head.next;
        while(fast!=null&&slow!=null){
            if(fast==slow){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }
        }
        return null;
    }
}
