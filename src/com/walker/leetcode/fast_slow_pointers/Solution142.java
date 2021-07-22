package com.walker.leetcode.fast_slow_pointers;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-22 23:45
 * @difficulty:
 * @link:
 **/
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
