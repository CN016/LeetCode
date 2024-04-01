package com.my016.arithmetic.learn;

import java.util.Scanner;

public class MainClass {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Student stu=new Student();
        //从控制台输入学生信息
        Teacher.inputInfo(stu,sc);
        //根据输入的学生信息进行处理：计算总评成绩及对应等级
        stu.updateGrade();
        //输出处理后的结果
        stu.outputInfo();
        sc.close();
    }

    private static class Student{
       private String name;
       private String id;
       private float aGrade;
       private float bGrade;
       private float cGrade;
       private float avg;
       private char   level;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public float getaGrade() {
            return aGrade;
        }

        public void setaGrade(float aGrade) {
            this.aGrade = aGrade;
        }

        public float getbGrade() {
            return bGrade;
        }

        public void setbGrade(float bGrade) {
            this.bGrade = bGrade;
        }

        public float getcGrade() {
            return cGrade;
        }

        public void setcGrade(float cGrade) {
            this.cGrade = cGrade;
        }

        public void updateGrade() {
            this.avg = aGrade *0.3f + bGrade*0.3f + cGrade *0.4f;
            if (avg>= 90){
                level = 'A';
                return;
            }
            if (avg>=80){
                level = 'B';
                return;
            }
            if (avg>=70 ){
                level = 'C';
                return;
            }
            if (avg>=60 ){
                level = 'D';
                return;
            }
            if (avg <60){
                level = 'E';
            }
        }

        public void outputInfo() {
            System.out.println("学号=姓名=平时成绩=实验成绩=期末考试=" + name +"("+id+")" + "的课程\"Java面向对象程序设计\"的成绩评定如下:");
            System.out.println("平时成绩:"+aGrade+'0');
            System.out.println("实验成绩:"+bGrade+'0');
            System.out.println("期末考试:"+cGrade+'0');
            System.out.println("总评:"+avg+",等级:"+level);
        }
    }

    private static class Teacher{

        public static void inputInfo(Student stu, Scanner sc) {
            stu.setId(sc.next());
            stu.setName(sc.next());
            stu.setaGrade(sc.nextFloat());
            stu.setbGrade(sc.nextFloat());
            stu.setcGrade(sc.nextFloat());
        }
    }

}