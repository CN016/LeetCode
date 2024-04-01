package com.my016.arithmetic;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortScanner {
    public static void main(String[] args) {
        String host = "106.52.247.57"; // 目标主机
        int timeout = 2000; // 连接超时时间（毫秒）

        System.out.println("开始端口扫描...");
        Map<Integer, Thread> threads = new HashMap<>(); // 线程列表，用于关闭线程
        for (int port = 1; port <= 65535; port++) {
            try {
//                if (threads.size() >= 5 ){
//                    port--;
//                    continue;
//                }
                int p = port;
                Socket socket = new Socket();
                Thread thread = new Thread(
                        () -> {
                            try {
                                socket.connect(new java.net.InetSocketAddress(host, p), timeout);
                                socket.close();
                                System.out.println("端口 " + p + " 开放");
                                threads.remove(p);
                            } catch (IOException e) {
//                                e.printStackTrace();
                                threads.remove(p);
                            }
                        }
                );
                thread.start();
                threads.put(port, thread);
            } catch (Exception e) {
                // 端口未开放，忽略异常
            }
        }

        System.out.println("端口扫描完成。");
    }
}
