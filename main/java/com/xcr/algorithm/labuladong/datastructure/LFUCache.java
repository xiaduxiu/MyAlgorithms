package com.xcr.algorithm.labuladong.datastructure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author: xia
 * @Date: 2021/1/20 15:17
 * @Version: v1.0
 */
public class LFUCache {

    private Map<Integer, Integer> keyToVal = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToKey = new HashMap<>();
    private int minFreq = 0;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val) {
        if (this.capacity <= 0) return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }

        if (this.capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }

        keyToVal.put(key, val);
        keyToFreq.put(key, 1);
        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);

        freqToKey.get(freq).remove(key);
        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);

        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKey.get(this.minFreq);
        Integer key = keys.iterator().next();
        keys.remove(key);
        if (keys.isEmpty()) {
            freqToKey.remove(this.minFreq);
        }
        keyToVal.remove(key);
        keyToFreq.remove(key);

    }
}
