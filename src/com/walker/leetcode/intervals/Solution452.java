package com.walker.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-30 23:37
 * @difficulty:
 * @link:
 **/
public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        for (int[] point : points) {
            if (point[0] > end) {
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
