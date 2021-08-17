package com.walker.leetcode.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-16 19:14
 * @difficulty:
 * @link:
 **/
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] need = new int[26];
        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            need[s2.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i : need) {
            if (i != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = s2.charAt(i - n) - 'a';
            int y = s2.charAt(i) - 'a';
            if (x == y) {
                continue;
            }
            if (need[x] == 0) {
                diff++;
            }
            need[x]++;
            if (need[x] == 0) {
                diff--;
            }
            if (need[y] == 0) {
                diff++;
            }
            need[y]--;
            if (need[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}
