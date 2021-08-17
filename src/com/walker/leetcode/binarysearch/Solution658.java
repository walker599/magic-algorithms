package com.walker.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-15 18:14
 * @difficulty:
 * @link:
 **/
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> arrs = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        int len = arr.length;
        if (arr[0] >= x) {
            return arrs.subList(0, k);
        }
        if (arr[len - 1] <= x) {
            return arrs.subList(len - k, len);
        }
        int pos = find(arr, x);
        int low = Math.max(0, pos - k);
        int high = Math.min(len - 1, pos + k);
        System.out.println(pos + " " + low + " " + high);
        while (high - low + 1 > k) {
            if (x - arr[low] <= arr[high] - x) {
                high--;
            }
            else {
                low++;
            }
        }
        return arrs.subList(low, high);
    }

    private int find(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return arr[left] > x ? left : left + 1;
    }
}
