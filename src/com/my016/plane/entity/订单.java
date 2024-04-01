package com.my016.plane.entity;

import java.util.Date;

@SuppressWarnings("NonAsciiCharacters")
public class 订单 {

    private String 姓名;

    private String 手机号;

    private Long  房间号;

    private String 房间名;

    private Date 日期;

    @Override
    public String toString() {
        return "订单：\n" +
                "姓名='" + 姓名 + '\'' +
                "\n手机号='" + 手机号 + '\'' +
                "\n房间号=" + 房间号 +
                "\n房间名='" + 房间名 + '\'' +
                "\n日期=" + 日期 +
                '\n';
    }

    public 订单() {
    }

    public 订单(String 姓名, String 手机号, Long 房间号, String 房间名, Date 日期) {
        this.姓名 = 姓名;
        this.手机号 = 手机号;
        this.房间号 = 房间号;
        this.房间名 = 房间名;
        this.日期 = 日期;
    }

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get手机号() {
        return 手机号;
    }

    public void set手机号(String 手机号) {
        this.手机号 = 手机号;
    }

    public Long get房间号() {
        return 房间号;
    }

    public void set房间号(Long 房间号) {
        this.房间号 = 房间号;
    }

    public String get房间名() {
        return 房间名;
    }

    public void set房间名(String 房间名) {
        this.房间名 = 房间名;
    }

    public Date get日期() {
        return 日期;
    }

    public void set日期(Date 日期) {
        this.日期 = 日期;
    }
}
