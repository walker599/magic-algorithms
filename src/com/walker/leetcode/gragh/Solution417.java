package com.walker.leetcode.gragh;

import java.util.*;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-27 00:34
 * @difficulty:
 * @link:
 **/
public class Solution417 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;
        int[][] pa = new int[m][n];
        int[][] at = new int[m][n];
        for (int i = 0; i < n; i++) {
            dfs(heights, pa, 0, i);
            dfs(heights, at, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pa, i, 0);
            dfs(heights, at, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pa[i][j] == 1 && at[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int[][] ocean, int i, int j) {
        ocean[i][j] = 1;
        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= matrix.length || nj >= matrix[0].length) {
                continue;
            }
            if (matrix[ni][nj] < matrix[i][j] || ocean[ni][nj] == 1) {
                continue;
            }
            dfs(matrix, ocean, ni, nj);
        }
    }
}
