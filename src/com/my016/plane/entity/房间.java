package com.my016.plane.entity;

import java.io.Serializable;

@SuppressWarnings("NonAsciiCharacters")
/*
  房间类
 */
public class 房间 implements Serializable {

    private final Long 房间号;

    private Boolean 是否是VIP房间;

    private final String 房间名;

    private Integer 当前人数;

    private final Integer 最大人数;

    /**
     * 构造器
     * @param num 最大人数
     * @param name 房间名
     * @param uuid 房间号
     */
    public 房间(int num,String name,long uuid){
        房间号 = uuid;
        最大人数 = num;
        房间名   = name;
        当前人数 = 0;
        是否是VIP房间 = false;
    }

    public static void main(String[] args) {

    }

    public Long get房间号() {
        return 房间号;
    }

    public Boolean get是否是VIP房间() {
        return 是否是VIP房间;
    }

    public void 不是VIP房间() {
        this.是否是VIP房间 = false;
    }

    public void 是VIP房间() {
        this.是否是VIP房间 = true;
    }

    public String get房间名() {
        return 房间名;
    }

    public void 加一人(){
        当前人数 += 1;
    }

    public void 减一人(){
        当前人数 -= 1;
    }


    public Integer get当前人数() {
        return 当前人数;
    }

    public Integer get最大人数() {
        return 最大人数;
    }
}
