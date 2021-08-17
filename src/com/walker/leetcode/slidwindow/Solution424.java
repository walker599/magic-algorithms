package com.walker.leetcode.slidwindow;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-16 20:11
 * @difficulty:
 * @link:
 **/
public class Solution424 {
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            int rc = s.charAt(right) - 'A';
            max = Math.max(max, ++count[rc]);
            if (right - left + 1 > max + k) {
                int lc = s.charAt(left) - 'A';
                count[lc]--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
