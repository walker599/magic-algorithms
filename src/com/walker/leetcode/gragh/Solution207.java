package com.walker.leetcode.gragh;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-17 18:00
 * @difficulty:
 * @link:
 **/
public class Solution207 {
    Set<Integer> visited = new HashSet<>();
    boolean flag = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            traverse(i, prerequisites);
            if (flag) {
                break;
            }
        }
        return !flag;
    }

    private void traverse(int course, int[][] prerequisites) {
        visited.add(course);
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == course) {
                int pre = prerequisites[i][1];
                if (visited.contains(pre)) {
                    flag = true;
                    return;
                }
                traverse(pre, prerequisites);
            }
        }
        visited.remove(course);
    }
}
