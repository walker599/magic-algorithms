package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 05:42
 * @difficulty:
 * @link:
 **/
public class Solution437 {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Integer, Integer> countMap = new HashMap<>();
            countMap.put(0, 1);
            return dfs(root, countMap, targetSum, 0);
        }

        private int dfs(TreeNode node, Map<Integer, Integer> countMap, int targetSum, int curSum) {
            if (node == null) {
                return 0;
            }
            int res = 0;
            curSum += node.val;
            res += countMap.getOrDefault(curSum - targetSum, 0);
            countMap.put(curSum, countMap.getOrDefault(curSum, 0) + 1);
            res += dfs(node.left, countMap, targetSum, curSum);
            res += dfs(node.right, countMap, targetSum, curSum);
            countMap.put(curSum, countMap.get(curSum) - 1);
            return res;
        }
}
