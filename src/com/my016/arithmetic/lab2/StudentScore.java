package com.my016.arithmetic.lab2;

public class StudentScore {

    public static void main(String[] args) {
        String[] studentNames = new String[10];
        float[]  studentScores = new float[10];
        int length = 0;
        System.out.println("开始输入学生信息，输入格式（姓名 成绩），请注意中间要有空格");
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入第" + (i+1) + "个学生的信息（输入-1停止输入）：");
            studentNames[length] = ScannerUtil.getNext();
            if ("-1".equals(studentNames[length])){
                break;
            }
            studentScores[length] = ScannerUtil.getNextFloat();
            length++;
        }
    }
}
