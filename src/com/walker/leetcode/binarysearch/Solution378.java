package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-07-28 01:33
 * @difficulty:
 * @link:
 **/
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkCount(matrix, mid, k)) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    private boolean checkCount(int[][] matrix, int mid, int k) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += (i + 1);
                j++;
            }
            else {
                i--;
            }
        }
        return count < k;
    }
}
