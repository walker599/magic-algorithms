package com.walker.leetcode.slidwindow;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-03 23:25
 * @difficulty:
 * @link:
 **/
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int curSum = 0;
        while (right < n) {
            curSum += nums[right];
            while (curSum >= target) {
                res = Math.min(right - left + 1, res);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
