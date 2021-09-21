package com.walker.leetcode.two_pointers;

import java.util.Arrays;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-02 23:26
 * @difficulty:
 * @link:
 **/
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closet = 100000;
        for (int first = 0; first < n - 2; first++) {
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
                if (sum < target) {
                    second++;
                }
                else {
                    third--;
                }
            }
        }
        return closet;
    }
}
