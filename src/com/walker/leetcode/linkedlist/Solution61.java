package com.walker.leetcode.linkedlist;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-28 00:42
 * @difficulty:
 * @link:
 **/
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while(tail.next != null) {
            len++;
            tail = tail.next;
        }
        if ((k = k % len) == 0) {
            return head;
        }
        k = len - k;
        for (int i = 0; i < k; i++) {
            tail.next = head;
            head = head.next;
            tail = tail.next;
            tail.next = null;
        }
        return head;
    }
}
