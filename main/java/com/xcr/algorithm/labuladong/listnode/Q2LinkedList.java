package com.xcr.algorithm.labuladong.listnode;

/**
 * 反转 每K个为一组的 链表元素
 * @Author: xia
 * @Date: 2021/1/18 10:35
 * @Version: v1.0
 */
public class Q2LinkedList {

    ListNode reverse(ListNode node) {
        ListNode pre, cur, next;
        pre = null;cur=node; next=node;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseN(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a= head; b=head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode listNode = reverseN(a, b);
        a.next = reverseGroup(b, k);
        return listNode;
    }

}
