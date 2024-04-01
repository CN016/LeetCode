package com.my016.arithmetic.lab2.api;

public class Charger implements ICharger{
    /**
     * 将充电器连接到交流电源上
     * @param voltage 交流电电压
     * @return 当voltage在[200-240]V范围时，返回true,否则返回false
     */
    @Override
    public boolean connectPowerline(float voltage) {
        if (!(voltage>=200 && voltage<=240)){
            System.out.print("交流电压不在[200,240]范围,无法充电");
        }
        return voltage>=200 && voltage<=240;
    }

    /**
     * 关电，停止充电
     */
    @Override
    public void powerOff() {
        System.out.print("充电器停止充电");
    }

    /**
     * 给手机充电，调用该方法1次，充电5%
     * @param currentEnergy 手机电池现有电量，[0-100]间的数
     * 若电量为100（满电），则停止充电，自动调用powerOff
     * @return 充电后的电池电量，若currentEnergy为10，则返回10+5=15
     */
    @Override
    public int doCharge(int currentEnergy) {
        if (currentEnergy >= 95){
            System.out.println("已充电到100%");
            powerOff();
            return 100;
        }
        System.out.println("已充电到"+(currentEnergy+5)+"%");

        return currentEnergy+5;
    }
}
