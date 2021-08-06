package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 19:57
 * @difficulty:
 * @link:
 **/
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        return serch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean serch(int[][] matrix, int target, int si, int sj, int ei, int ej) {
        if (si > ei || sj > ej) {
            return false;
        }
        if (matrix[si][sj] > target || matrix[ei][ej] < target) {
            return false;
        }
        int mj = sj + (ej - sj) / 2;
        int mi = si;
        while (mi <= ei && matrix[mi][mj] <= target) {
            if (matrix[mi][mj] == target) {
                return true;
            }
            mi++;
        }
        return serch(matrix, target, mi, sj, ei, mj - 1) || serch(matrix, target, si, mj + 1, mi - 1, ej);
    }
}
