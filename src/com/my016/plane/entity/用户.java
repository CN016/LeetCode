package com.my016.plane.entity;

import com.my016.plane.utils.操作;

@SuppressWarnings("NonAsciiCharacters")
public class 用户 {

    private String 姓名;

    private Integer 年龄;

    private String 手机号;

    private String 身份证号码;

    public 用户(){
        操作.用户信息输入(this);
    }

    public String get姓名() {
        return 姓名;
    }

    public Integer get年龄() {
        return 年龄;
    }

    public String get手机号() {
        return 手机号;
    }

    public String get身份证号码() {
        return 身份证号码;
    }
}
