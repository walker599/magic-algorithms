package com.walker.leetcode.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-26 16:26
 * @difficulty:
 * @link:
 **/
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            indeg[v]++;
            edges.get(u).add(v);
        }
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;
            for (Integer v : edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
