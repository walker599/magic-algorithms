package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 17:26
 * @difficulty:
 * @link:
 **/
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                l++;
                r--;
            }
            else if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
            else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
        }
        return false;
    }
}
