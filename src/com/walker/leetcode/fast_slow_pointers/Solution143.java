package com.walker.leetcode.fast_slow_pointers;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-25 23:50
 * @difficulty:
 * @link:
 **/
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode midNode = middleNode(head);
        ListNode lastHalf = revList(midNode.next);
        midNode.next = null;
        merge(head, lastHalf);
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode tmpL1 = l1.next;
            ListNode tmpL2 = l2.next;
            l1.next = l2;
            l2.next = tmpL1;
            l1 = tmpL1;
            l2 = tmpL2;
        }
    }

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode revList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = revList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
