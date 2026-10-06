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


        LruNode<K,V> node = map.get(key);
        if(node!=null){
            node.value=value;
            if(node!=head){
                node.previous.next=node.next;          // removing node from the position
                node.next.previous=node.previous;

                LruNode<K,V> temp=head;

                node.next=temp;
                temp.previous=node;     // putting node as head

                node.previous=null;
                head=node;
            }
            return;
        }
        else{
            LruNode<K,V> newnode = new LruNode<>(key,value);      //create node
            map.put(key,newnode);
            if(head==null){
                head=tail=newnode;
            }else{
                newnode.next=head;
                head.previous=newnode;                  //put it as head
                newnode.previous=null;
                head=newnode;
            }
            if(map.size()>capacity){
                removeTail();                  // to remove LRU process if cache buffer is full
            }
        }
    }

    private void removeTail(){
        map.remove(tail.key);
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        tail=tail.previous;
        tail.next=null;
    }


}