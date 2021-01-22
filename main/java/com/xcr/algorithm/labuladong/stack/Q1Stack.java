package com.xcr.algorithm.labuladong.stack;

import java.util.Stack;
import java.util.Vector;

/**
 * 单调栈
 * @Author: xia
 * @Date: 2021/1/21 11:15
 * @Version: v1.0
 */
public class Q1Stack {

    public static Vector<Integer> nextGreaterElement(Vector<Integer> nums) {
        Vector<Integer> result = new Vector<>(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.size()-1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums.get(i)) {
                stack.pop();
            }
            result.set(i, stack.isEmpty()? -1: stack.peek());
            stack.push(nums.get(i));
        }
        return result;
    }

    public static Vector<Integer> nextGreaterElements(Vector<Integer> nums) {
        Vector<Integer> result = new Vector<>(nums);
        Stack<Integer> stack = new Stack<>();
        int n = nums.size();
        for (int i = (n*2)-1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums.get(i% n)) {
                stack.pop();
            }
            result.set(i%n, stack.isEmpty()? -1: stack.peek());
            stack.push(nums.get(i%n));
        }
        return result;
    }

    public static Vector<Integer> dailyTemperatures(Vector<Integer> nums) {
        Vector<Integer> result = new Vector<>(nums);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.size()-1; i >= 0 ; i--) {
            while (!stack.isEmpty() && nums.get(stack.peek()) <= nums.get(i)) {
                stack.pop();
            }
            result.set(i, stack.isEmpty()? 0 : (stack.peek()-i));
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>();
        integers.add(2);
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(3);
        Vector<Integer> integers1 = Q1Stack.nextGreaterElements(integers);
        System.out.println(integers1);
    }

}
