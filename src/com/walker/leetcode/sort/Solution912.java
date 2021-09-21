package com.walker.leetcode.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-13 23:39
 * @difficulty:
 * @link:
 **/
public class Solution912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pos = new Random().nextInt(end - start + 1) + start;
        int pivot = nums[pos];
        nums[pos] = nums[start];
        nums[start] = pivot;
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[right] > pivot && left < right) {
                right--;
            }
            while (nums[left] <= pivot && left < right) {
                left++;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        nums[start] = nums[left];
        nums[left] = pivot;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
}
