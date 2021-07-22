package com.walker.leetcode.fast_slow_pointers;

import com.walker.leetcode.ListNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-23 00:01
 * @difficulty:
 * @link:
 **/
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode sum = new ListNode();
        ListNode tail = sum;
        int x, y, z;
        int q = 0;
        while (l1 != null && l2 != null) {
            x = l1.val;
            y = l2.val;
            int tmpSum = x + y + q;
            z = tmpSum % 10;
            q = tmpSum / 10;
            ListNode tmpNode = new ListNode(z);
            tail.next = tmpNode;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            x = l1.val;
            int tmpSum = x + q;
            z = tmpSum % 10;
            q = tmpSum / 10;
            ListNode tmpNode = new ListNode(z);
            tail.next = tmpNode;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            x = l2.val;
            int tmpSum = x + q;
            z = tmpSum % 10;
            q = tmpSum / 10;
            ListNode tmpNode = new ListNode(z);
            tail.next = tmpNode;
            tail = tail.next;
            l2 = l2.next;
        }
        if (q > 0) {
            ListNode tmpNode = new ListNode(q);
            tail.next = tmpNode;
        }
        return sum.next;
    }
}
