package com.walker.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-18 18:25
 * @difficulty:
 * @link: https://www.nowcoder.com/question/next?pid=31385606&qid=1867538&tid=46577494
 **/
public class Solution202181802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");
        int n = Integer.parseInt(params[0]);
        int k = Integer.parseInt(params[1]);
        int[] attack = new int[n];
        int[] money = new int[n];
        params = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            attack[i] = Integer.parseInt(params[i]);
        }
        params = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(params[i]);
        }
    }
}
