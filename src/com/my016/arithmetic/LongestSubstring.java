package com.my016.arithmetic;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        String s = "uqinntq";
        //Set<Character> set = new HashSet<>();
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }

    private static class Solution {
        int count = 1;
        public int lengthOfLongestSubstring(String s) {
            if ("".equals(s)){
                return 0;
            }
            leftSearchLength(s,0,s.length()-1);
            rightSearchLength(s,0,s.length()-1);
            return count;
        }
        private void leftSearchLength(String s , int start , int end){
            if (start >= end){
                return;
            }
            int mid = start/2 + end /2;
            if (s.charAt(start) != s.charAt(end)){
                // searchLength(s,start+1 , end-1);
                for (int i = start + 1; i < end; i++) {
                    if (s.charAt(i) == s.charAt(i+1) ){
                        if (i>=mid){
                            leftSearchLength(s,i-1,i);
                            return;
                        }
                    }
                    if (s.charAt(i) == s.charAt(end)){
                        leftSearchLength(s,i,end-1);
                        return;
                    }
                    if (s.charAt(i-1) == s.charAt(i)){
                        if (i<=mid){
                            leftSearchLength(s,i,end);
                            return;
                        }
                    }
                }
                count = end - start +1;
            }else {
                leftSearchLength(s,start,end-1);
            }
        }
        private void rightSearchLength(String s , int start , int end){
            if (start >= end){
                return;
            }
            int mid = start/2 + end /2;
            if (s.charAt(start) != s.charAt(end)){
                // searchLength(s,start+1 , end-1);
                for (int i = end -1; i > start; i--) {
                    if (s.charAt(i) == s.charAt(i+1) ){
                        if (i>=mid){
                            rightSearchLength(s,i-1,i);
                            return;
                        }
                    }
                    if (s.charAt(i) == s.charAt(start)){
                        rightSearchLength(s,start,i-1);
                        return;
                    }
                    if (s.charAt(i-1) == s.charAt(i)){
                        if (i<=mid){
                            rightSearchLength(s,start,i);
                            return;
                        }
                    }
                }
                count = Math.max(count, end - start +1 );
            }else {
                rightSearchLength(s,start+1,end);
            }
        }
    }

    private static class Solution1{
        public int lengthOfLongestSubstring(String s) {
            if ("".equals(s)){
                return 0;
            }
            int max = 0;
            int count = 0;
            Set<Character> characters = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (characters.contains(s.charAt(i))){
                    characters.clear();
                    max = Math.max(max,count);
                    count = 1;
                    characters.add(s.charAt(i));
                }else {
                    characters.add(s.charAt(i));
                    count++;
                }
            }
            if (!characters.isEmpty()){
                  max = Math.max(characters.size() , max);
            }
            characters.clear();
            count = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                if (characters.contains(s.charAt(i))){
                    characters.clear();
                    max = Math.max(max,count);
                    count = 1;
                    characters.add(s.charAt(i));
                }else {
                    characters.add(s.charAt(i));
                    count++;
                }
            }
            if (!characters.isEmpty()){
                max = Math.max(characters.size() , max);
            }

            characters.clear();
            int mid = (s.length()-1)/2;
            int st = mid  , en = mid+1;
            while (st>=0 && en <= s.length()-1){
                if (characters.contains(s.charAt(st))){
                    max = Math.max(characters.size() , max);
                    characters.clear();
                    en++;
                    continue;
                }else {
                    characters.add(s.charAt(st));
                    count++;
                }
                if (characters.contains(s.charAt(en))){
                    max = Math.max(characters.size() , max);
                    characters.clear();
                    st--;
                    continue;
                }else {
                    characters.add(s.charAt(en));
                    count++;
                }

                st--;
                en++;
            }
            if (!characters.isEmpty()){
                max = Math.max(characters.size() , max);
            }
            return max;
        }
    }

    private static class Solution2{
        public int lengthOfLongestSubstring(String s){
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }
    }

    private static class Solution3{
        public int lengthOfLongestSubstring(String s) {
            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                res   = Math.max(res, i - start + 1);
                last[index] = i;
            }

            return res;
        }
    }
}
