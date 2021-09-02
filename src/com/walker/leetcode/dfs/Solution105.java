package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 15:47
 * @difficulty:
 * @link:
 **/
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int val = preorder[preLeft];
        int pos = inLeft;
        while (inorder[pos] != val && pos <= inRight) {
            pos++;
        }
        int leftLen = pos - inLeft;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftLen, inLeft, pos - 1);
        root.right = buildTree(preorder, inorder, preLeft + leftLen + 1, preRight, pos + 1, inRight);
        return root;
    }
}
