package com.walker.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-30 23:27
 * @difficulty:
 * @link:
 **/
public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxExec = 0;
        for (char task : tasks) {
            int exec = freq.getOrDefault(task, 0) + 1;
            freq.put(task, exec);
            maxExec = Math.max(maxExec, exec);
        }
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> set = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            Integer value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }
        return Math.max(tasks.length, (maxExec - 1) * (n + 1) + maxCount);
    }
}
