package com.walker.leetcode.unclassfied;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-05 19:39
 * @difficulty:
 * @link:
 **/
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return b[0] - a[0];
                }
                else {
                    return a[1] - b[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        ans.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            int pos = people[i][1];
            ans.add(pos, people[i]);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }
        return res;
    }
}
