package com.hxh.project.exception;


import com.hxh.project.enums.ResultEnum;
import com.hxh.project.utils.TimeUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huangxunhui
 * Date: Created in 2018-12-18 10:25
 * Utils: Intellij Idea
 * Description: 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 方法名称
     */
    private final String method;

    /**
     * 异常发生时间
     */
    private final String time;

    /**
     * 自定义异常
     *
     * @param resultEnum 返回枚举对象
     * @param method     方法
     */
    public CustomException(ResultEnum resultEnum, String method) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.time = TimeUtil.getCurrentTime();
        this.method = method;
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     * @param method  方法
     */
    public CustomException(Integer code, String message, String method) {
        super(message);
        this.code = code;
        this.time = TimeUtil.getCurrentTime();
        this.method = method;
    }
}
