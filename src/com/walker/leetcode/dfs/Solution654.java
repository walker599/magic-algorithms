package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 06:11
 * @difficulty:
 * @link:
 **/
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = nums[left];
        int maxPos = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, left, maxPos - 1);
        root.right = constructMaximumBinaryTree(nums, maxPos + 1, right);
        return root;
    }
}
