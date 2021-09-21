package com.walker.leetcode.linkedlist;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-14 12:36
 * @difficulty:
 * @link:
 **/
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode tail) {
        if (head == tail || head.next == tail) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next, tail);
        next.next = head;
        return newHead;
    }
}
