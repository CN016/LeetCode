package com.my016.arithmetic.lab2.api;

import java.util.Scanner;

public class Telephone {
    ICharger charger;
    private int currentEnergy;
    public Telephone() {
        //begin，请在begin-end之间添加一条语句，不要改动其他任何代码，否则为0分。
        charger = new Charger();
        //end
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        Telephone tel=new Telephone();
        System.out.println("请输入交流电压和当前手机电量:");
        float vol=sc.nextFloat();
        tel.currentEnergy=sc.nextInt();
        tel.beginCharge(vol);
        sc.close();
    }
    private void beginCharge(float vol) {
        if(charger.connectPowerline(vol)) {
            while(true) {
                currentEnergy=charger.doCharge(currentEnergy);
                if(currentEnergy==100) {
                    break;
                }
            }
        }
    }

}
