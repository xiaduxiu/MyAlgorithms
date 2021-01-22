package com.xcr.algorithm.labuladong.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xia
 * @Date: 2021/1/22 16:55
 * @Version: v1.0
 */
public class Q2Stack {
    public Queue<Integer> queue = new LinkedList<>();
    int top = 0;


    public void push(int num) {
        queue.add(num);
        top = num;
    }

    public int pop() {
        int size = queue.size();
        // 留下队尾 2 个元素
        while (size > 2) {
            queue.add(queue.poll());
            size--;
        }
        // 记录新的队尾元素
        top = queue.peek();
        queue.offer(queue.poll());
        // 删除之前的队尾元素
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
