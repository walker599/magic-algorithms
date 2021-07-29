package com.walker.leetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-29 23:29
 * @difficulty:
 * @link:
 **/
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> inters = new ArrayList<>();
        for (int[] interval : intervals) {
            inters.add(interval);
        }
        Collections.sort(inters,(o1, o2) -> o1[0] - o2[0]);
        int end = 0;
        for (int i = 1; i < inters.size(); i++) {
            if (inters.get(end)[1] >= inters.get(i)[0]) {
                if (inters.get(end)[1] < inters.get(i)[1]) {
                    int[] tmp = new int[2];
                    tmp[0] = inters.get(end)[0];
                    tmp[1] = inters.get(i)[1];
                    inters.set(end, tmp);
                }
            }
            else {
                end++;
                inters.set(end, inters.get(i));
            }
        }
        inters = inters.subList(0, end + 1);
        int[][] res = new int[inters.size()][2];
        for (int i = 0; i < inters.size(); i++) {
            res[i][0] = inters.get(i)[0];
            res[i][1] = inters.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution56().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
