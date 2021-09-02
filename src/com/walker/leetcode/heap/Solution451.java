package com.walker.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 15:54
 * @difficulty:
 * @link:
 **/
public class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            int cnt = map.get(c);
            while (cnt-- > 0) {
                ans.append(c);
            }
        }
        return new String(ans);
    }
}
