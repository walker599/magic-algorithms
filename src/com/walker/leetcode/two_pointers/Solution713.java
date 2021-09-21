package com.walker.leetcode.two_pointers;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-03 00:24
 * @difficulty:
 * @link:
 **/
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
