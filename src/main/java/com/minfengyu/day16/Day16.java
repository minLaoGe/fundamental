package com.minfengyu.day16;

import com.minfengyu.common.Node2;

import java.util.Arrays;
import java.util.HashMap;

public class Day16 {
    public Node2 insert(Node2 head, int insertVal){
        Node2 node = new Node2(insertVal);
        if (head==null){
            head=node;
            head.next=head;
        }else if (head.next==head){
            head.next=node;
            node.next=head;
        }else{
            insertCore(head,node);
        }
        return head;
    }

    private void insertCore(Node2 head, Node2 node) {
        Node2 cur=head;
        Node2 next=head.next;
        Node2 biggest=head;
        while (!(cur.val<=node.val&&next.val>=node.val)&&next!=head){
            cur=next;
            next=next.next;
            if (cur.val>=biggest.val){
                biggest=cur;
            }
        }
        if (cur.val<=node.val&&next.val>=node.val){
            cur.next=node;
            node.next=next;
        }else {
            node.next=biggest.next;
            biggest.next=node;
        }
    }

    public Day16() {
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();
        Node2 node2 = Node2.composeNode2(Arrays.asList(3, 3, 3));
        Node2 insert = day16.insert(node2, 0);
        System.out.println(insert);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

    }
}
