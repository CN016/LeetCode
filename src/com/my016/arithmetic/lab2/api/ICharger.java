package com.my016.arithmetic.lab2.api;

/**
 * 提供给充电设计公司的接口
 * @author guet.imagan
 *
 */
public interface ICharger {
    /**
     * 将充电器连接到交流电源上
     * @param voltage 交流电电压
     * @return 当voltage在[200-240]V范围时，返回true,否则返回false
     */
    boolean connectPowerline(float voltage);
    /**
     * 关电，停止充电
     */
    void powerOff();
    /**
     * 给手机充电，调用该方法1次，充电5%
     * @param currentEnergy 手机电池现有电量，[0-100]间的数
     * 若电量为100（满电），则停止充电，自动调用powerOff
     * @return 充电后的电池电量，若currentEnergy为10，则返回10+5=15
     */
    int doCharge(int currentEnergy);
}