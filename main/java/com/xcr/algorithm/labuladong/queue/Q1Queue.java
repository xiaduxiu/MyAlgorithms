package com.xcr.algorithm.labuladong.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单调栈
 * @Author: xia
 * @Date: 2021/1/21 14:21
 * @Version: v1.0
 */
public class Q1Queue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonitorQueue window = new MonitorQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.add(window.max());
                window.pop(nums[i-k+1]);
            }
        }
        int[] result = new int[res.size()];
        for (int j = 0; j <res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }

    private class MonitorQueue {
        LinkedList<Integer> list = new LinkedList<>();

        public void push(int num) {
            while (!list.isEmpty() && list.getLast() < num) {
                list.pollLast();
            }
            list.addLast(num);
        }

        public int max() {
            return list.getFirst();
        }

        public void pop(int num) {
            if (num == list.getFirst()) {
                list.pollFirst();
            }
        }
    }
}
