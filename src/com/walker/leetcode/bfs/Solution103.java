package com.walker.leetcode.bfs;

import com.walker.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-27 16:07
 * @difficulty:
 * @link:
 **/
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (height % 2 == 0) {
                    tmp.add(node.val);
                }
                else {
                    tmp.add(0, node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(tmp);
            height++;
        }
        return res;
    }
}
