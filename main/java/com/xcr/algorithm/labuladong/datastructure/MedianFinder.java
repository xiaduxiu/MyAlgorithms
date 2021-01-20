package com.xcr.algorithm.labuladong.datastructure;

import java.util.PriorityQueue;

/**
 * @Author: xia
 * @Date: 2021/1/20 17:41
 * @Version: v1.0
 */
public class MedianFinder {

    /**
     * 295
     * 数据流的中位数
     */
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }
        if (small.size() <= large.size()) {
            large.offer(num);
            small.offer(large.poll());
        }

    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }

}
