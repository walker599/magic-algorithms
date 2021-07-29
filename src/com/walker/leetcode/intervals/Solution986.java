package com.walker.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-30 00:03
 * @difficulty:
 * @link:
 **/
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][];
        }
        int i = 0, j = 0;
        int m = firstList.length;
        int n = secondList.length;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int a = firstList[i][0], b = firstList[i][1];
            int x = secondList[i][0], y = secondList[i][1];
            if (x > b) {
                i++;
            } else if (a > y) {
                j++;
            } else {
                res.add(new int[]{Math.max(a, x), Math.min(b, y)});
                if (b <= y) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
