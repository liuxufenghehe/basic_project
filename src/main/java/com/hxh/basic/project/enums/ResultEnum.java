package com.hxh.basic.project.enums;


import lombok.Getter;

/**
 * @author huangxunhui
 * Date: Created in 18/8/29 上午9:54
 * Utils: Intellij Idea
 * Description: 返回状态枚举类
 */
@Getter
public enum ResultEnum {

    /**
     * 未知异常
     */
    UNKNOWN_EXCEPTION(100, "未知异常"),

    /**
     * 格式错误
     */
    FORMAT_ERROR(101, "参数格式错误"),

    /**
     * 超时
     */
    TIME_OUT(102, "超时"),

    /**
     * 添加失败
     */
    ADD_ERROR(103, "添加失败"),

    /**
     * 更新失败
     */
    UPDATE_ERROR(104, "更新失败"),

    /**
     * 删除失败
     */
    DELETE_ERROR(105, "删除失败"),

    /**
     * 查找失败
     */
    GET_ERROR(106, "查找失败"),

    /**
     * 参数类型不匹配
     */
    ARGUMENT_TYPE_MISMATCH(107, "参数类型不匹配"),

    /**
     * 请求方式不支持
     */
    REQ_METHOD_NOT_SUPPORT(110,"请求方式不支持"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 通过状态码获取枚举对象
     * @param code 状态码
     * @return 枚举对象
     */
    public static ResultEnum getByCode(int code){
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if(code == resultEnum.getCode()){
                return resultEnum;
            }
        }
        return null;
    }

}

