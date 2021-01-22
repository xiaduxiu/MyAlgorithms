package com.xcr.algorithm.labuladong.queue;

import java.util.Stack;

/**
 * @Author: xia
 * @Date: 2021/1/22 16:48
 * @Version: v1.0
 */
public class Q2Queue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public void push(int num) {
        s1.push(num);
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public int pop(){
        peek();
        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
