package com.walker.leetcode.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-22 23:32
 * @difficulty: EASY
 * @link: https://leetcode-cn.com/problems/two-sum/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 **/
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum)) {
                return new int[]{map.get(anotherNum), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
