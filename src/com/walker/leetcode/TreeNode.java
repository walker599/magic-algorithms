package com.walker.leetcode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-17 00:10
 * @difficulty: None
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
