package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;
import org.w3c.dom.css.CSSUnknownRule;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 05:17
 * @difficulty:
 * @link:
 **/
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, new ArrayList<>(), targetSum, 0);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, List<Integer> curPath, int targetSum, int curSum) {
        curSum += node.val;
        curPath.add(node.val);
        if (isLeaf(node) && curSum == targetSum) {
            res.add(new ArrayList<>(curPath));
        }
        if (node.left != null) {
            dfs(node.left, res, curPath, targetSum, curSum);
        }
        if (node.right != null) {
            dfs(node.right, res, curPath, targetSum, curSum);
        }
        curPath.remove(curPath.size() - 1);
    }
    private boolean isLeaf (TreeNode node) {
        return node.left == null && node.right == null;
    }
}
