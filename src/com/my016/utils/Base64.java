package com.my016.utils;


import com.my016.lab2.utils.ScannerUtil;

import java.io.*;

public class Base64 {
    /**
     * 本地图片转base64
     */
    public static String getImgFileToBase642(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] buffer = null;
        //读取图片字节数组
        try(InputStream inputStream = new FileInputStream(imgFile)){
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        java.util.Base64.Encoder encode = java.util.Base64.getEncoder();
        return encode.encodeToString(buffer);
    }


    /**
     * base64转图片存储在本地
     * @param imgBase64 图片base64
     * @param imgPath 图片本地存储地址
     */
    public static boolean getImgBase64ToImgFile(String imgBase64, String imgPath) {
        boolean flag = true;
        java.util.Base64.Decoder decode = java.util.Base64.getDecoder();
        try (OutputStream outputStream = new FileOutputStream(imgPath)){
            // 解密处理数据
            byte[] bytes = decode.decode(imgBase64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(getImgFileToBase642("src/com/my016/utils/1.png"));
        String s = ScannerUtil.getNext();
        getImgBase64ToImgFile(s,"src/com/my016/utils/2.png");
    }



}
