package com.walker.leetcode.two_pointers;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-06-23 00:03
 * @difficulty: EASY
 * @link: https://leetcode-cn.com/problems/backspace-string-compare/
 **/
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        return trans(s).equals(trans(t));
    }
    private String trans(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                sb.append(s.charAt(i));
            }
            else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    public boolean backspaceCompare2(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skips = 0;
        int skipt = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                    i--;
                }
                else if (skips > 0) {
                    skips--;
                    i--;
                }
                else {
                    break;
                }
            }
            while (j >= 0) {
                if (s.charAt(j) == '#') {
                    skipt++;
                    j--;
                }
                else if (skipt > 0) {
                    skipt--;
                    j--;
                }
                else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            }
            else  {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
