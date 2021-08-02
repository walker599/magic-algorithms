package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 00:09
 * @difficulty:
 * @link:
 **/
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }
}
