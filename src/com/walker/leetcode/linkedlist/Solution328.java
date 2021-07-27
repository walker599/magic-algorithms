package com.walker.leetcode.linkedlist;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-28 01:05
 * @difficulty:
 * @link:
 **/
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        int pos = 1;
        ListNode tail = head;
        ListNode pre = head.next;
        while (pre.next != null) {
            if (pos % 2 == 0) {
                pre = pre.next;
            }
            else {
                ListNode tmp = tail.next;
                tail.next = pre.next;
                tail = tail.next;
                pre.next = pre.next.next;
                tail.next = tmp;
            }
            pos++;
        }
        return head;
    }
}
