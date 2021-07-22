package com.walker.leetcode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-17 00:09
 * @difficulty: None
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
