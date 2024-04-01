package com.my016.arithmetic.lab2.learn1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    private final int rowCount;
    private final int colCount;
    public double[][] data;

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String[][] strings = processArrays();
        s.append('[');
        for (int i = 0; i < strings.length; i++) {
            s.append(Arrays.toString(strings[i]).replaceAll(" ",""))
                    .append(  i==data.length-1 ? "" : ",\n "  );
        }
        s.append(']');
        return s.toString();
    }

    private String[][] processArrays(){
        String[][] s = new String[rowCount][colCount];
        DecimalFormat df = new DecimalFormat("0.00#");
        //指定RoundingMode
        df.setRoundingMode(RoundingMode.HALF_UP);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String t = df.format(data[i][j]);
                s[i][j] = t;
            }
        }
        return s;
    }

    public int getRowCount() {
        return rowCount;
    }


    public int getColCount() {
        return colCount;
    }


    public Matrix(int rowCount, int colCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
        data = new double[rowCount][colCount];
    }

    public Matrix(double[][] data){
        this.data = data;
        this.rowCount = data.length;
        this.colCount = data[0].length;
    }

    public Matrix plus(double num){
        double[][] n = new double[this.rowCount][this.colCount];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                n[i][j]=this.data[i][j] + num;
            }
        }
        return new Matrix(n);
    }

    public Matrix plus(Matrix matrix){
        double[][] res = new double[matrix.getRowCount()][matrix.getColCount()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = this.data[i][j] + matrix.data[i][j];
            }
        }
        return new Matrix(res);
    }

    public Matrix multiply(double num){
        double[][] n = new double[this.rowCount][this.colCount];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                n[i][j]=this.data[i][j]*num;
            }
        }
        return new Matrix(n);
    }

    public Matrix multiply(Matrix matrix){
        if (this.colCount != matrix.getRowCount()){
            return null;
        }
        double[][] res = new double[this.rowCount][matrix.getColCount()];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                for (int k = 0; k < matrix.data[0].length; k++) {
                    res[i][k] += data[i][j] * matrix.data[j][k];
                }
            }
        }
        return new Matrix(res);
    }

    public Matrix transpose() {
        double[][] n = new double[this.colCount][this.rowCount];
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                n[i][j] = this.data[j][i];
            }
        }
        return new Matrix(n);
    }



    private static class MainClass{
        public static Scanner sc=new Scanner(System.in);
        public static void main(String[] args) {
            int rowCount,colCount;
            System.out.println("输入矩阵行列数");
            rowCount=sc.nextInt();
            colCount=sc.nextInt();

            //创建1个rowCount×colCount的矩阵,矩阵所有元素初始化为0
            Matrix matA=new Matrix(rowCount,colCount);
            MainClass.inputMatrix(matA);
            System.out.println("矩阵A=\n"+matA);
            Matrix matB=new Matrix(rowCount,colCount);
            MainClass.inputMatrix(matB);
            System.out.println("矩阵B=\n"+matB);
            System.out.println("运算结果如下:");
            //执行矩阵相加运算
            Matrix matC=matA.plus(matB);
            System.out.println("C=\n"+matC);
            //修改matA的第2行，第2列的那个元素
            matA.data[1][1]=89.4;
            //执行矩阵与一个数相加的运算，即矩阵的所有元素都加上这个数
            Matrix matD=matA.plus(5.6);
            System.out.println("D=\n"+matD);
            //执行矩阵和1个数相乘，即矩阵的所有元素都乘上这个数
            Matrix matF=matA.multiply(3.4);
            System.out.println("F=\n"+matF);
            //求转置矩阵
            Matrix matG=matA.transpose();
            System.out.println("G=\n"+matG);
            //执行矩阵乘法，若matA的列数≠matB的行数，则返回null
            Matrix matE=matA.multiply(matG);
            //按[[1,2,3],[4,5,6]]类似格式输出矩阵，这里的逗号都是英文逗号
            System.out.println("E=\n"+matE);
            MainClass.sc.close();
        }
        private static void inputMatrix(Matrix mat) {
            int rowCount=mat.getRowCount();
            int colCount=mat.getColCount();

            System.out.println("输入"+rowCount+"×"+colCount+"矩阵");
            for(int i=0;i<rowCount;i++) {
                for(int j=0;j<colCount;j++) {
                    System.out.print("["+i+"]["+j+"]=");
                    mat.data[i][j]=sc.nextDouble();
                }
            }
        }
    }


}
