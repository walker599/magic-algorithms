package com.walker.leetcode.binarysearch;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 00:02
 * @difficulty:
 * @link:
 **/
public class Solution153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
