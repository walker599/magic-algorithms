package com.walker.leetcode.gragh;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-27 01:12
 * @difficulty:
 * @link:
 **/
public class Solution200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
