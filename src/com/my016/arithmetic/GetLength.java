package com.my016.arithmetic;

public class GetLength {
    public static void main(String[] args) {
        System.out.println("🎵".length());
        String B = "𝄞"; // 这个就是那个音符字符，只不过由于当前的网页没支持这种编码，所以没显示。
        String C = "\uD834\uDD1E";// 这个就是音符字符的UTF-16编码
        System.out.println(C);
        System.out.println(B.length());
        System.out.println(B.codePointCount(0,B.length()));

    }
}
