package com.xcr.algorithm.labuladong.listnode;


/**
 * @Author: xia
 * @Date: 2021/1/18 14:25
 * @Version: v1.0
 */
public class Q3LinkedList {

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l --;
            r ++;
        }
        return s.substring(l+1, r-l-1);
    }

    public boolean isPalindrome(String s) {
        int left =0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }


    ListNode left;
    public boolean isPalindrome(ListNode node) {
        left = node;
        return reverse(node);
    }

    public boolean reverse(ListNode node) {
        if (node == null) return true;
        boolean reverse = reverse(node.next);
        reverse = reverse & (left.value == node.value);
        left = left.next;
        return reverse;
    }


    public boolean isPalindrome2(ListNode node) {
        ListNode left = node;
        ListNode right = reverse2(findMiddleNode(node));

        while (right != null) {
            if (left.value != right.value) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode findMiddleNode(ListNode node) {
        ListNode slow, fast;
        slow = node; fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse2(ListNode node) {
        ListNode pre, cur;
        pre = null; cur =node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
