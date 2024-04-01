package com.my016.arithmetic;

import java.util.ArrayList;

public class BigNumAdd {

    public static void main(String[] args) {
        String s1 = Scanner.next();
        String s2 = Scanner.next();
        Solution solution = new Solution();
        System.out.println(solution.solve(s1, s2));
    }

    private static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 计算两个数之和
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public String solve (String s, String t) {
            // write code here
            char[] ss = s.toCharArray();
            char[] ts = t.toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = ss.length-1; i >= 0; i--) {
                list.add(ss[i]);
            }
            int index = 0;
            int flag  = 0;
            for (int i = ts.length-1; i >= 0; i--) {
                char l = list.get(index);
                int num = l - '0' + ts[i] - '0' + flag;
                if ( num > 9){
                    list.set(index, (char)(num -10 + '0'));
                    flag = 1;
                }else {
                    list.set(index, (char)(num + '0'));
                }
                index++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() -1 ; i >= 0; i--) {
                sb.append(list.get(i));
            }
            return sb.toString();
        }
    }
}
