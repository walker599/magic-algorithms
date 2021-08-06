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
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int curSum = nums[0];
        while (right < nums.length) {
            if (curSum >= target) {
                int curLen = right - left + 1;
                res = Math.min(res, curLen);
                curSum -= nums[left];
                left++;
            }
            else {
                right++;
                if (right == nums.length)
                curSum += nums[right];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
