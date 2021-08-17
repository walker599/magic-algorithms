package com.walker.leetcode.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 13:17
 * @difficulty:
 * @link:
 **/
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            count.put(rc, count.getOrDefault(rc, 0) + 1);
            while (count.size() < right - left + 1) {
                char lc = s.charAt(left);
                count.put(lc, count.get(lc) - 1);
                if (count.get(lc) == 0) {
                    count.remove(lc);
                }
                left++;
            }
            ans = Math.max(count.size(), ans);
            right++;
        }
        return ans;
    }
}
