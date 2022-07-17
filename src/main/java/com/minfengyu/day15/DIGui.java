package com.minfengyu.day15;

import  com.minfengyu.common.Node;
public class DIGui {
    public static void main(String[] args) {

    }
        public Node flatten(Node head) {
            Node cur=head;
            while(cur!=null){
                Node next=cur.next;
                if(cur.child!=null){
                    cur.next=cur.child;
                    cur.child.prev=cur;
                    Node child= flatten(cur.child);
                    child.child=null;
                    child.next=next;
                    next.prev=child;
                }
                cur=next;
            }
            return head;
        }
}
