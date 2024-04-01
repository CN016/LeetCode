package com.my016.arithmetic;

public class PalindromeChecker {
    private static boolean isPalindromeRecursive(String substring) {
        // 如果字符串长度为0或1，它是回文的
        if (substring.length() <= 1) {
            return true;
        }
        // 如果首尾字符相同，则递归检查去除首尾字符的子串
        else if (substring.charAt(0) == substring.charAt(substring.length() - 1)) {
            return isPalindromeRecursive(substring.substring(1, substring.length() - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // 示例
        String inputString = "isisisisi";
        boolean result = isPalindromeRecursive(inputString);
        System.out.println(result);
    }
}
