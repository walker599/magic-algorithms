package com.walker.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-02 04:19
 * @difficulty:
 * @link:
 **/
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = - nums[first];
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                if (nums[second] + nums[third] < target) {
                    second++;
                }
                else if (nums[second] + nums[third] > target) {
                    third--;
                }
                else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                }
            }
        }
        return ans;
    }

}
