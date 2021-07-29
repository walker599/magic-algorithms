package com.walker.leetcode.heap;

import java.util.*;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-29 01:01
 * @difficulty:
 * @link:
 **/
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>(k, (pair1, pair2) -> pair1.get(0) + pair1.get(1) - pair2.get(0) - pair2.get(1));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(n1);
                tmp.add(n2);
                if (heap.size() < k) {
                    heap.offer(tmp);
                }
                else {

                }
            }
        }
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }
}
