package com.walker.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 17:28
 * @difficulty:
 * @link:
 **/
public class Solution767 {
    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(i)));
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (Character c : map.keySet()) {
            pq.offer(c);
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 1) {
            char a = pq.poll();
            char b = pq.poll();
            int cnt1 = map.get(a);
            int cnt2 = map.get(b);
            ans.append(a);
            ans.append(b);
            if (cnt1 > 1) {
                map.put(a, cnt1 - 1);
                pq.offer(a);
            }
            if (cnt2 > 1) {
                map.put(b, cnt2 - 1);
                pq.offer(b);
            }
        }
        if (!pq.isEmpty()) {
            ans.append(pq.poll());
        }
        return ans.toString();
    }
}
