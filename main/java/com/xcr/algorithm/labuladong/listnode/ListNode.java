package com.xcr.algorithm.labuladong.listnode;

/**
 * @Author: xia
 * @Date: 2021/1/18 10:33
 * @Version: v1.0
 */
public class ListNode {

    int value;
    ListNode next;

    public ListNode() {}
    public ListNode(int value) { this.value = value; }
    public ListNode(int value, ListNode node) { this.value = value; this.next=node; }
}
