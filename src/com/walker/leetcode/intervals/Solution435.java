package com.walker.leetcode.intervals;

import java.util.Arrays;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-30 01:03
 * @difficulty:
 * @link:
 **/
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int right = intervals[0][1];
        int n = intervals.length;
        for (int[] interval : intervals) {
            if (interval[0] >= right) {
                ans++;
                right = interval[1];
            }
        }
        return n - ans;
    }
}
