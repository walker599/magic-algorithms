package com.walker.leetcode.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-26 17:11
 * @difficulty:
 * @link:
 **/
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            indeg[pre[0]]++;
            edges.get(pre[1]).add(pre[0]);
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);
            for (Integer v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (ans.size() != numCourses) {
            return new int[0];
        }
        int[] a = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
