package com.walker.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-08-18 18:00
 * @difficulty:
 * @link: https://www.nowcoder.com/test/question/6f66e5d889bd410f844c742b286d3c70?pid=31385606&tid=46577494
 **/
public class Solution202181801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String params = br.readLine().trim();
        int t = Integer.parseInt(params);
        List<Integer> ans = new ArrayList<>();
        while (t-- > 0) {
            String s = br.readLine().trim();
            List<Integer> nums = new ArrayList<>();
            int ones = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    if (ones != 0) {
                        nums.add(ones);
                    }
                    ones = 0;
                }
                else {
                    ones++;
                }
            }
            if (s.charAt(s.length() - 1) == '1') {
                nums.add(ones);
            }
            nums.sort((a, b) -> b -a );
            int niumei = 0;
            int niuniu = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (i % 2 == 0) {
                    niumei += nums.get(i);
                }
                else {
                    niuniu += nums.get(i);
                }
            }
            ans.add(niumei - niuniu);
        }
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i) > 0) {
                System.out.println("Niumei");
                System.out.println(ans.get(i));
            }
            else {
                System.out.println("Draw");
            }
        }
    }
}
