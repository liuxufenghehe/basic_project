package com.hxh.project.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huangxunhui
 * Date: Created in 2019-03-12 10:58
 * Utils: Intellij Idea
 * Description: 时间工具类
 */
public class TimeUtil {

    /**
     * 私有化构造方法防止被实例化
     */
    private TimeUtil() {
    }

    /**
     * 获取当前时间精确到秒
     *
     * @return 返回当前时间
     */
    public static String getCurrentTime() {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(day);
    }

    /**
     * 获取当前Unix时间戳
     *
     * @return 返回当前时间戳
     */
    public static String getUnixTime() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

}
