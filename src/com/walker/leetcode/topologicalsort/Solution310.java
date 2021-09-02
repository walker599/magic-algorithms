package com.walker.leetcode.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-27 15:43
 * @difficulty:
 * @link:
 **/
public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> edgesList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgesList.add(new ArrayList<>());
        }
        int[] deg = new int[n];
        for (int[] edge : edges) {
            deg[edge[0]]++;
            deg[edge[1]]++;
            edgesList.get(edge[0]).add(edge[1]);
            edgesList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                res.add(u);
                for (Integer v : edgesList.get(u)) {
                    deg[v]--;
                    if (deg[v] == 1) {
                        q.offer(v);
                    }
                }
            }
        }
        return res;
    }
}
