package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 19:47
 * @difficulty:
 * @link:
 **/
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int p = l + (r - l) / 2;
            int i = p / n;
            int j = p % n;
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                l = p + 1;
            }
            else {
                r = p - 1;
            }
        }
        return false;
    }
}
