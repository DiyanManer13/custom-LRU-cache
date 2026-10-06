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
}
