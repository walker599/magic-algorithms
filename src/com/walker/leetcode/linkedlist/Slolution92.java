package com.walker.leetcode.linkedlist;

import com.walker.leetcode.ListNode;

import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-28 00:04
 * @difficulty:
 * @link:
 **/
public class Slolution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nxt = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = nxt;
        }
        return newHead.next;
    }
}
