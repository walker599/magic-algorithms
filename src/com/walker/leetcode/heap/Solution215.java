package com.walker.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 16:11
 * @difficulty:
 * @link:
 **/
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer num : map.keySet()) {
            pq.offer(num);
        }
        int cur = 0;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            cur += map.get(num);
            if (cur >= k) {
                return num;
            }
        }
        return 0;
    }
}
