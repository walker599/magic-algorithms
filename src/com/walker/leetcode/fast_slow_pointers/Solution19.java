package com.walker.leetcode.fast_slow_pointers;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-23 00:24
 * @difficulty:
 * @link:
 **/
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i <= n ; i++) {
            if (fast == null) {
                return head.next;
            }
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
