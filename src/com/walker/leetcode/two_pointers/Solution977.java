package com.walker.leetcode.two_pointers;

import java.util.Arrays;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-22 23:49
 * @difficulty: EASY
 * @link: https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 **/
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }
    public int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];
        int neg = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            }
            else {
                break;
            }
        }
        int start = 0;
        int left = neg;
        int right = neg + 1;
        while (left >= 0 && right < nums.length) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[start++] = nums[left] * nums[left];
                left--;
            }
            else {
                res[start++] = nums[right] * nums[right];
                right++;
            }
        }
        while (left >= 0) {
            res[start++] = nums[left] * nums[left];
            left--;
        }
        while (right < nums.length) {
            res[start++] = nums[right] * nums[right];
            right++;
        }
        return res;
    }
}
