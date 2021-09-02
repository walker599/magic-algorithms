package com.walker.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 15:35
 * @difficulty:
 * @link:
 **/
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        final Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
        for (Integer key : countMap.keySet()) {
            pq.offer(key);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
