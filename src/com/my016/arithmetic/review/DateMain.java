package com.my016.arithmetic.review;

import java.time.LocalDate;

public class DateMain {

    public static void main(String[] args) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.parse("2023-08-01");
        // 减去30天
        LocalDate thirtyDaysAgo = currentDate.minusDays(30);

        System.out.println("30天前的日期是：" + thirtyDaysAgo);
    }

}
