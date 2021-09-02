package com.walker.leetcode.bfs;

import com.walker.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-31 15:04
 * @difficulty:
 * @link:
 **/
public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TmpNode> q = new LinkedList<>();
        q.offer(new TmpNode(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int start = q.peek().pos;
            for (int i = 0; i < size; i++) {
                TmpNode tmp = q.poll();
                res = Math.max(res, tmp.pos - start + 1);
                if (tmp.node.left != null) {
                    q.offer(new TmpNode(tmp.node.left, tmp.pos * 2));
                }
                if (tmp.node.right != null) {
                    q.offer(new TmpNode(tmp.node.right, tmp.pos * 2 + 1));
                }
            }
        }
        return res;
    }
}
class TmpNode {
    TreeNode node;
    int pos;

    public TmpNode(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}
