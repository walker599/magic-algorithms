package com.walker.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 15:15
 * @difficulty:
 * @link:
 **/
public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]));
        for (int[] point : points) {
            pq.offer(point);
        }
        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }
        return ans;
    }
}
