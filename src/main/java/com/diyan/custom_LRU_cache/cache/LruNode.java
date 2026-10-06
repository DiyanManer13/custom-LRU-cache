package com.diyan.custom_LRU_cache.cache;

public class LruNode<K,V> {
    K key;
    V value;
    LruNode<K,V> previous;
    LruNode<K,V> next;

    LruNode(K key,V value){
        this.key=key;
        this.value=value;
    }
}
