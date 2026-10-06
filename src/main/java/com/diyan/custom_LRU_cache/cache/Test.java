package com.diyan.custom_LRU_cache.cache;

public class Test {
    public static void main(String[] args) {
        CustomLRUCache<Integer,String> test = new CustomLRUCache<>(3);
        test.put(10,"A");
        test.put(20,"B");
        test.put(30,"C");

        System.out.println(test.get(10));
        System.out.println(test.get(20));
        System.out.println(test.get(30));

        test.put(40,"D");



        System.out.println(test.get(10));
    }
}

