package com.walker.leetcode.linkedlist;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-28 00:50
 * @difficulty:
 * @link:
 **/
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            cur.next = cur.next.next;
            first.next = first.next.next;
            cur.next.next = first;
            cur = first;
        }
        return newHead.next;
    }
}
