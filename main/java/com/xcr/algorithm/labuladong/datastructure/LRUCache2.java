package com.xcr.algorithm.labuladong.datastructure;

import java.util.LinkedHashMap;

/**
 * @Author: xia
 * @Date: 2021/1/20 16:09
 * @Version: v1.0
 */
public class LRUCache2 {

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int cap;

    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    private void makeRecently(int key) {
        Integer integer = cache.get(key);
        cache.remove(integer);
        cache.put(key, integer);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }
        if (this.cap <= cache.size()) {
            Integer next = cache.keySet().iterator().next();
            cache.remove(next);
        }
        cache.put(key, val);
    }
}
