package com.walker.leetcode.slidwindow;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-07 03:11
 * @difficulty:
 * @link:
 **/
public class Solution995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int ans = 0;
        int revCnt = 0;
        for (int i = 0; i < n; i++) {
            revCnt += diff[i];
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                ans++;
                revCnt++;
                diff[i + k]--;
            }
        }
        return ans;
    }
}
