package com.walker.leetcode.two_pointers;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-03 00:36
 * @difficulty:
 * @link:
 **/
public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int tmp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = tmp;
                p1++;
            }
            else if (nums[i] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                if (p0 < p1) {
                    tmp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = tmp;
                }
                p0++;
                p1++;
            }
        }
    }
}
