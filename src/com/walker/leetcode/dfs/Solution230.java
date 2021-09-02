package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 14:05
 * @difficulty:
 * @link:
 **/
public class Solution230 {
    int ans = 0;
    int cur = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return ans;
        }
        dfs(root, k);
        return ans;
    }

    private void dfs(TreeNode node, int k) {
        if (node.left != null) {
            dfs(node.left, k);
        }
        cur++;
        if (cur == k) {
            ans = node.val;
        }
        else if (node.right != null) {
            dfs(node.right, k);
        }
    }
}
