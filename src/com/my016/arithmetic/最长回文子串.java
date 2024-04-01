package com.my016.arithmetic;

@SuppressWarnings("NonAsciiCharacters")
public class 最长回文子串 {
    public static void main(String[] args) {
        String 字符串 = "babad";
        String 最长字串 = new 解决方案().最长字串(字符串);
        System.out.println(最长字串);
    }

    @SuppressWarnings("NonAsciiCharacters")
    public static class 解决方案 {
        public String 最长字串(String 字符串) {
        if (字符串 == null || 字符串.length() == 0){
            return "";
        }
        int[] 范围数组 = new int[2];
        char[] 字符串数组 = 字符串.toCharArray();
            for (int 循环变量 = 0; 循环变量 < 字符串.length(); 循环变量++) {
                循环变量 = 找最长(字符串数组,循环变量 , 范围数组);
            }
            return 字符串.substring(范围数组[0],范围数组[1] + 1);
        }
        private static int 找最长(char[] 字符串数组, int 低位 , int[] 范围数组){
            int 高位 = 低位;
            while (高位 < 字符串数组.length-1 && 字符串数组[高位+1] == 字符串数组[低位]){
                高位++;
            }
            int 记录 = 高位;
            while (低位 > 0 && 高位 < 字符串数组.length - 1 && 字符串数组[低位 - 1] == 字符串数组[高位 + 1]) {
                低位--;
                高位++;
            }
            if (高位 - 低位 > 范围数组[1] - 范围数组[0]) {
                范围数组[0] = 低位;
                范围数组[1] = 高位;
            }
            return 记录;
        }
    }
}
