package com.minfengyu.day16;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int i = lruCache.get(1);
        System.out.println(i);
        lruCache.put(3,3);
        int i4 = lruCache.get(2);
        System.out.println(i4);
        lruCache.put(4,4);
        int i1 = lruCache.get(1);
        System.out.println(i1);
        int i2 = lruCache.get(3);
        int i3 = lruCache.get(4);
        System.out.println(i2);
        System.out.println(i3);
    }
    Map<Integer,NodeList> map;
    int capacity;
    NodeList head;
    NodeList tail;
    public LRUCache(int capacity) {
        map=new HashMap(capacity);
        head = new NodeList(-1,-1);
        tail = new NodeList(-1,-1);
        head.nextNode=tail;
        tail.preNode=head;
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            NodeList nodeList=map.get(key);
            int returnValue=nodeList.value;
            deleteNode(nodeList);
            addNode(nodeList);
            return returnValue;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        NodeList nodeList= new NodeList(key,value);
        if(!map.containsKey(key)&&map.size()<capacity){
            addNode(nodeList);
        }else if(!map.containsKey(key)&&map.size()>=capacity){
            NodeList nextFirstNode=head.nextNode;
            deleteNode(nextFirstNode);
            addNode(nodeList);
            map.remove(nextFirstNode.key);
        }else{
            modifyNode(key,nodeList);
        }
        map.put(key,nodeList);
    }
    public void modifyNode(int key,NodeList nodeList){
        NodeList origin=map.get(key);
        deleteNode(origin);
        addNode(nodeList);
    }
    public void deleteNode(NodeList origin){
        NodeList preNode=origin.preNode;
        NodeList nextNode=origin.nextNode;
        preNode.nextNode=nextNode;
        nextNode.preNode=preNode;
    }
    public void addNode(NodeList nodeList){
        NodeList lastNode= tail.preNode;
        lastNode.nextNode=nodeList;
        tail.preNode=nodeList;
        nodeList.preNode=lastNode;
        nodeList.nextNode=tail;
    }

    class NodeList{
        public NodeList nextNode;
        public int value;
        public int key;
        public NodeList preNode;
        public NodeList(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */