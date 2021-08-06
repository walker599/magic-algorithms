package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 17:04
 * @difficulty:
 * @link:
 **/
public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[0]) {
                if (nums[l] <= target && target < nums[m]) {
                    h = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
            else {
                if (nums[m] < target && target <= nums[h]) {
                    l = m + 1;
                }
                else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }
}
