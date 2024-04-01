package com.my016.arithmetic;


import java.util.Scanner;



public class mainer {

    public static class point {
        float x,y;
        point(float x,float y){
            this.x = x;
            this.y = y;
        }
        point(){

        }
        void set(float x,float y){
            System.out.println("点的坐标为：");
            System.out.println("X = "+x+"Y = "+y);
        }

    }


    public static class  Circle{
        Scanner read = new Scanner(System.in);
        point Center;
        float Radiu;
        float cent;
        float area;
        float distance;
        //    float x,y;
        void set(point Center,float x,float y){
            Center = new point(x,y);

        }
        void get(point Center){
            System.out.println("原点的坐标为"+"x = "+Center.x+"y = "+Center.y);

        }
        float complate_c(float radiu){
            System.out.println("请输入设定的pi的值");
            float pi = read.nextFloat();
            cent = 2*radiu*pi;
            return cent;
        }
        float complate_s(float radiu){
            float pi;
            System.out.println("请输入设定的PI的值");
            pi = read.nextFloat();
            area = pi*radiu*radiu;
            return area;
        }
        int pint(point P1, Circle C1){           //判断一个点是否在员圆内
            int transe = 0;
            float distance;
            P1 = new point();
            C1 = new Circle();
            C1.Center = new point();
            distance = (P1.x - C1.Center.x)*(P1.x - C1.Center.x)+(P1.y - C1.Center.y)*(P1.y - C1.Center.y);
            if(distance > C1.Radiu*C1.Radiu)
                transe = 1;
            else if(distance ==C1.Radiu*C1.Radiu )
                transe = 0;
            else transe = -1;
            return transe;
        }
    }
    private static class CI{
        int y_Y_GX(Circle C1,Circle C2){            //判断距离的方法
            float distance;
            float x,y;
            int transe = 0;
            C1 = new Circle();
            C2 = new Circle();
            C1.Center = new point();
            C2.Center = new point();
            distance = (C1.Center.x - C2.Center.x)*(C1.Center.x - C2.Center.x)+(C1.Center.y - C2.Center.y)*(C1.Center.y - C2.Center.y);
            if(distance < (C1.Radiu+C2.Radiu)*(C1.Radiu+C2.Radiu)){
                transe = -1;
            }
            else if(distance == (C1.Radiu+C2.Radiu)*(C1.Radiu+C2.Radiu)){
                transe = 0;
            }
            else if(distance > (C1.Radiu+C2.Radiu)*(C1.Radiu+C2.Radiu)){
                transe = 1;
            }
            return transe;
        }
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        float x,y;
        float trance;
        System.out.println("请输入第一个圆的原点坐标");
        x = read.nextFloat();
        y = read.nextFloat();
        point pin1 = new point(x,y);
        pin1.set(pin1.x,pin1.y);

        System.out.println("请输入圆的半径:");
        Circle Cir = new Circle();
        Cir.set(pin1,x,y);

        Cir.Radiu = read.nextFloat();
        System.out.println("圆的面积是："+Cir.complate_s(Cir.Radiu)+"CM^2");
        System.out.println("圆的周长是："+Cir.complate_c(Cir.Radiu)+"CM");

        System.out.println("请输入一个点坐标");
        x = read.nextFloat();
        y = read.nextFloat();
        point pin2 = new point(x,y);
        pin2.set(pin2.x,pin2.y);

        //输出点的坐标
        trance = Cir.pint(pin2,Cir);
        if(trance >1){
            System.out.println("这个点在圆外");
        }else if(trance == 0){
            System.out.println("这个点在圆上");
        }
        else System.out.println("这个点在圆内");

        Circle Cir1 = new Circle();
        Cir1.Center = new point();
        System.out.println("输入第二个圆的圆心坐标x,y"+"以及半径R");
        Cir1.Center.x = read.nextFloat();
        Cir1.Center.y = read.nextFloat();
        Cir1.Radiu = read.nextFloat();
        CI CI1 = new CI();

        trance = CI1.y_Y_GX(Cir1,Cir);
        if(trance == -1){
            System.out.println("两个圆相交");
        }else if(trance == 0){
            System.out.println("这两个圆相切");
        }
        else if(trance == 1){
            System.out.println("这两个圆相离");
        }




    }


}



