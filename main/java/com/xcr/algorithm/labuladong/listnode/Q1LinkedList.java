package com.xcr.algorithm.labuladong.listnode;

/**
 * 反转[m,n]区间的链表元素
 * @Author: xia
 * @Date: 2021/1/14 14:56
 * @Version: v1.0
 */
public class Q1LinkedList {

    ListNode reverse(ListNode node) {
        if (node.next == null) return node;
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    ListNode reverseN(ListNode node, int n) {
        ListNode successor = null;
        if (n == 1) {
            successor = node.next;
            return node;
        }
        ListNode last = reverseN(node.next, n - 1);
        node.next.next = node;
        node.next = successor;
        return last;
    }

    ListNode reverseBetween(ListNode node, int m, int n) {
        if (m == 1) {
            return reverseN(node, n);
        }
        node.next = reverseBetween(node, m - 1, n-1);
        return node;
    }
}
