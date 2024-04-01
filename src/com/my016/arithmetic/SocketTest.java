package com.my016.arithmetic;

import java.io.*;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        String message = "/root/watermarking/modelfiles/016_image/4b52686f-2341-47c7-abe1-5c99895d39cd/"
                    +"#"+"/root/watermarking/modelfiles/016_output//root/watermarking/modelfiles/016_image/4b52686f-2341-47c7-abe1-5c99895d39cd//";
        System.out.println(socket(message));

    }

    /**
     * 发包工具
     */
    private static String socket(String message){
        String host = "127.0.0.1";  // Python服务器的地址
        int port = 30019;            // Python服务器的端口号

        try {
            // 连接到Python服务器
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(1000);

            System.out.println("Connected to Python server");
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(message.getBytes());
            // 接收Python服务器返回的数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String response = reader.readLine();
            socket.close();
            // 关闭套接字
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
