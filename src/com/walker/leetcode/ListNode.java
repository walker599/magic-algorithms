package com.walker.leetcode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-17 00:09
 * @difficulty: None
 **/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
