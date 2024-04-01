package com.my016.arithmetic.work4;

import java.io.*;

public class LogFilter {

    public static void main(String[] args) throws Exception{

        String url = "F:\\360Downloads\\runtime-info-2024-03-23-0.log";
        int k = 0;
        double j = 0;

            File file = new File(url);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = "withDeviceInfoToMyResMed查询线上线下接口请求时长：";
            String l;
            while (true){
                try {
                    if ( (l = reader.readLine()).contains(line)) {
                        int i = l.lastIndexOf("：");
                        String substring = l.substring(i+1);
//                        System.out.println(substring);
                        double l1 = Double.parseDouble(substring);
                        System.out.println(l1);
                        k++;
                        j+=l1;
                    }
                } catch (IOException | NullPointerException e) {
                    break;
                }
            }

//
        System.out.println( "平均：" + j/k);
        System.out.println( "总计记录：" + k);
    }

}
