package com.diyan.custom_LRU_cache.cache;

import java.util.HashMap;

public class CustomLRUCache<K,V> {
    HashMap<K,LruNode<K,V>> map = new HashMap<>();
    LruNode<K,V> head;
    LruNode<K,V> tail;
    int capacity;

    public CustomLRUCache(int capacity){
        this.capacity=capacity;
    }

    public void put (K key,V value){
        LruNode<K,V> newnode = new LruNode<>(key,value);

        map.put(key,newnode);
        if(head==null){
            head=tail=newnode;
        }else{
            newnode.next=head;
            head.previous=newnode;
            newnode.previous=null;
            head=newnode;
        }
    }

    private void removeTail(){
        map.remove(tail.key);
        if(head==tail){
            head.next=null;
            tail=null;
            return;
        }
        tail=tail.previous;
        tail.next=null;


    }
}
