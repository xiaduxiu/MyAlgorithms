package com.xcr.algorithm.labuladong.listnode;

import java.util.Random;

/**
 * @Author: xia
 * @Date: 2021/1/20 16:43
 * @Version: v1.0
 */
public class Q4LinkedList {

    /**
     * 随机获取链表节点
     */
    private ListNode head;

    public int getRandom() {
        Random random = new Random();
        int index = 0, result = 0;

        ListNode p = head;
        while (p != null) {
            if (random.nextInt(index++) == 0) {
                result = p.value;
            }
            p = p.next;
        }

        return result;
    }
}
