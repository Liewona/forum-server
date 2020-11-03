package com.qf.forum.utils;
/*
 *   Author = Liewona
 *   Date = 2020/11/3 0:37
 */

import java.text.SimpleDateFormat;

public class CommUtil {
    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    private CommUtil(){ }

    public static String getNowDateTime() {
        return dateFormatThreadLocal.get().format(System.currentTimeMillis());
    }


}
