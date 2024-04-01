package com.my016.arithmetic.work5;

import java.util.Scanner;

public class Test1 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Animal animal = null;
        String type = sc.nextLine();
        if ("马".equals(type)){
            Horse h = new Horse(type,"2010-1-9");
            h.run();
            animal = h;
        }else if("金鱼".equals(type)){      //改了点代码
            Goldfish g = new Goldfish(type,"2019-10-20");
            g.swim();
            animal = g;
        }
        animal.eat();
        animal.showInfo();
        sc.close();
    }
}
