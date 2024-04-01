package com.my016.arithmetic;

public class MaxRepeatedChar {

    public static void main(String[] args) {
        // 示例
        String inputString = "14444112442aa44442244311222222244445444243334444ccc4444";
        char[] result = maxRepeatedCharAndCount(inputString);
        System.out.println("" + result[0] + " " + result[1]);
    }

    public static char[] maxRepeatedCharAndCount(String s) {
        //非空判断
        if (s == null || s.isEmpty()) {
            return new char[]{'\0', 0};
        }

        char maxChar = s.charAt(0);
        char currentChar = s.charAt(0);
        int currentCount = 1;
        int maxCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = s.charAt(i);      //连续字符的切换
                currentCount = 1;
            }

            if (currentCount > maxCount) {              //更新最大长度和记录最大的字符
                maxChar = currentChar;
                maxCount = currentCount;
            }
        }

        return new char[]{maxChar, (char)(maxCount + '0')};
    }
}
