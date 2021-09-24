package com.walker.leetcode.gragh;

import java.util.*;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-24 14:08
 * @difficulty:
 * @link:
 **/
public class Solution743 {
    int[] dis;

    public int networkDelayTime(int[][] times, int n, int k) {
        dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int value = time[2];
            int[] node = new int[2];
            node[0] = to;
            node[1] = value;
            graph[from].add(node);
        }
        return dijkstra(k - 1, graph);
    }

    private int dijkstra(int start, List<int[]>[] graph) {
        dis[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State a, State b) {
                return a.disFormStart - b.disFormStart;
            }
        });
        pq.offer(new State(start, 0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNode = curState.node;
            int curDistFromStart = curState.disFormStart;
            if (curDistFromStart > dis[curNode]) {
                continue;
            }
            for (int[] nextNode : graph[curNode]) {
                int nextNodeId = nextNode[0];
                int disToNextNode = dis[curNode] + nextNode[1];
                if (disToNextNode < dis[nextNodeId]) {
                    dis[nextNodeId] = disToNextNode;
                    pq.offer(new State(nextNodeId, disToNextNode));
                }
            }
        }
        int maxDis = dis[0];
        for (int d : dis) {
            if (d == Integer.MAX_VALUE) {
                return -1;
            }
            maxDis = Math.max(maxDis, d);
        }
        return maxDis;
    }

    class State {
        int node;
        int disFormStart;

        public State(int node, int disFormStart) {
            this.node = node;
            this.disFormStart = disFormStart;
        }
    }
}
