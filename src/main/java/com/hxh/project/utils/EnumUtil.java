package com.hxh.project.utils;


import com.hxh.project.enums.CodeEnum;

/**
 * @author 黄训辉
 * Date: Created in 2018/1/13 12:16
 * Utils: Intellij Idea
 * Description: 枚举工具类
 */
public class EnumUtil {

    /**
     * 私有化构造方法 防止被实例化
     */
    private EnumUtil() {
    }

    /**
     * 通过枚举CODE获取枚举对象
     *
     * @param code      状态码
     * @param enumClass 枚举类
     * @param <T>       泛型
     * @return 返回枚举对象
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (each.getCode().equals(code)) {
                return each;
            }
        }
        return null;
    }
}
