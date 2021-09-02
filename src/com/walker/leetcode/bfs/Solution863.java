package com.walker.leetcode.bfs;

import com.walker.leetcode.TreeNode;

import java.util.*;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-27 16:48
 * @difficulty:
 * @link:
 **/
public class Solution863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        dfs(graph, root);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(target.val);
        visited.add(target.val);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) {
                for (int i = 0; i < size; i++) {
                    res.add(q.poll());
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                for (Integer v : graph.get(u)) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        q.offer(v);
                    }
                }
            }
            distance++;
        }
        return res;
    }

    private void dfs(Map<Integer, Set<Integer>> graph, TreeNode root) {
        int u = root.val;
        if (!graph.containsKey(u)) {
            graph.put(u, new HashSet<>());
        }
        if (root.left != null) {
            int v = root.left.val;
            graph.get(u).add(v);
            graph.put(v, new HashSet<>());
            graph.get(v).add(u);
            dfs(graph, root.left);
        }
        if (root.right != null) {
            int v = root.right.val;
            graph.get(u).add(v);
            graph.put(v, new HashSet<>());
            graph.get(v).add(u);
            dfs(graph, root.right);
        }
    }
}
