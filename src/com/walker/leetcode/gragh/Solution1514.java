package com.walker.leetcode.gragh;

import java.util.*;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-24 15:11
 * @difficulty:
 * @link:
 **/
public class Solution1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<Nod>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            graph[node1].add(new Nod(node2, succProb[i]));
            graph[node2].add(new Nod(node1, succProb[i]));
        }
        double[] proTo = new double[n];
        Arrays.fill(proTo, 0);
        proTo[start] = 1;
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State a, State b) {
                return Double.compare(b.proFromStart, a.proFromStart);
            }
        });
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeId = curState.id;
            double curPro = curState.proFromStart;
            if (curNodeId == end) {
                return curPro;
            }
            if (curPro < proTo[curNodeId]) {
                continue;
            }
            for (Nod neighbors : graph[curNodeId]) {
                int nextNodeId = neighbors.id;
                double nextPro = neighbors.pro * proTo[curNodeId];
                if (nextPro > proTo[nextNodeId]) {
                    proTo[nextNodeId] = nextPro;
                    pq.offer(new State(nextNodeId, nextPro));
                }
            }
        }
        return -1;
    }

    class State {
        int id;
        double proFromStart;

        public State(int id, double proFromStart) {
            this.id = id;
            this.proFromStart = proFromStart;
        }
    }

    class Nod {
        int id;
        double pro;

        public Nod(int id, double pro) {
            this.id = id;
            this.pro = pro;
        }
    }
}
