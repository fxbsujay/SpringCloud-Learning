package com.susu.springcloud.common;

import java.time.ZonedDateTime;

public class DateUtils {

    public static void main(String[] args) {
        // 2022-04-09T15:55:09.281+08:00[Asia/Shanghai]
        ZonedDateTime time = ZonedDateTime.now();

        System.out.println(time);
    }
}
