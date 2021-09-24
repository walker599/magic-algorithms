package com.walker.leetcode.gragh;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-24 15:44
 * @difficulty:
 * @link:
 **/
public class Solution1631 {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] efforts = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State a, State b) {
                return a.effort - b.effort;
            }
        });
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new State(0, 0, 0));
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curX = state.x;
            int curY = state.y;
            int curEffort = state.effort;
            if (curX == row - 1 && curY == col - 1) {
                return curEffort;
            }
            if (curEffort > efforts[curX][curY]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dirs[i][0];
                int nextY = curY + dirs[i][1];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                    continue;
                }
                int nextEffort = Math.max(curEffort, Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                if (nextEffort < efforts[nextX][nextY]) {
                    efforts[nextX][nextY] = nextEffort;
                    pq.offer(new State(nextX, nextY, nextEffort));
                }
            }
        }
        return -1;
    }

    class State {
        int x;
        int y;
        int effort;

        public State(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }
}
