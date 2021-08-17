package com.walker.leetcode.slidwindow;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-16 16:10
 * @difficulty:
 * @link:
 **/
public class Solution904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        //水果类型不到两种，直接返回
        if (n <= 1) {
            return n;
        }
        int ans = 0;
        //记录当前窗口内每种水果的数量
        Map<Integer, Integer> fruitCountMap = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < n) {
            int fruit = fruits[right];
            fruitCountMap.put(fruit, fruitCountMap.getOrDefault(fruit, 0) + 1);
            while (fruitCountMap.size() > 2) {
                int f = fruits[left];
                fruitCountMap.put(f, fruitCountMap.get(f) - 1);
                if (fruitCountMap.get(f) == 0) {
                    fruitCountMap.remove(f);
                }
                left++;
            }
            ans = Math.max(ans, right - left +  1);
            right++;
        }
        return ans;
    }
}
