package com.my016.arithmetic.lab3;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("E:\\myjava\\LeetCode\\src\\com\\my016\\arithmetic\\lab3\\1.txt");

        byte[] a = {89,97,86,111};
        outputStream.write(a);
        outputStream.close();

    }
}
