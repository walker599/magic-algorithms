package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 06:07
 * @difficulty:
 * @link:
 **/
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightA = lowestCommonAncestor(root.right, p, q);
        if (leftA != null && rightA != null) {
            return root;
        }
        return leftA == null ? rightA : leftA;
    }
}
