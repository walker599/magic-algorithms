package com.walker.leetcode.dfs;

import com.walker.leetcode.TreeNode;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-17 00:10
 * @difficulty: Eazy
 **/
public class Solution572 {
    /*解法一*/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
    /*解法二*/
    boolean res = false;
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        dfs2(root, subRoot);
        return res;
    }

    private void dfs2(TreeNode t, TreeNode s) {
        if (isSame(t, s)) {
            res = true;
            return;
        }
        if (res) {
            return;
        }
        if (t.left != null) {
            dfs2(t.left, s);
        }
        if (t.right != null) {
            dfs2(t.right, s);
        }
    }

    private boolean isSame(TreeNode t, TreeNode s) {
        if (t == null && s == null) {
            return true;
        }
        if (t == null || s == null || s.val != t.val) {
            return false;
        }
        return isSame(t.left, s.left) && isSame(t.right, s.right);
    }
    /*以上两种方法没有本质区别，都是基于DFS*/
}
