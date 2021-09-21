package com.walker.leetcode.two_pointers;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-03 00:50
 * @difficulty:
 * @link:
 **/
public class Solution11 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int cur = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, cur);
            if (height[left] < height[right]) {
                left++;
            }
            else if (height[left] > height[right]) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        return max;
    }
}
