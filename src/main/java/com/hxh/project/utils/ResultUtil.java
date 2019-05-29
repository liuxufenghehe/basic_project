package com.hxh.project.utils;


import com.hxh.project.dto.ResultBean;
import com.hxh.project.enums.ResultEnum;

/**
 * @author huangxunhui
 * Date: Created in 18/8/20 上午11:05
 * Utils: Intellij Idea
 * Description: 返回数据工具类
 */
public class ResultUtil {

    /**
     * 私有化工具类 防止被实例化
     * j
     */
    private ResultUtil() {}

    /**
     * 成功
     * @param object 需要返回的数据
     * @return data
     */
    public static ResultBean success(Object object) {
        ResultBean result = new ResultBean();
        result.setCode(0);
        result.setMessage("ok");
        result.setData(object);
        return result;
    }

    /**
     * 成功
     * @return 返回空
     */
    public static ResultBean success() {
        return success(null);
    }

    /**
     * 错误
     * @param resultEnum 错误枚举类
     * @return 错误信息
     */
    public static ResultBean error(ResultEnum resultEnum) {
        ResultBean result = new ResultBean();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMsg());
        return result;
    }

    /**
     * 错误
     * @param code 状态码
     * @param msg 消息
     * @return ResultBean
     */
    public static ResultBean error(Integer code, String msg) {
        ResultBean result = new ResultBean();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    /**
     * 错误
     * @param msg 错误信息
     * @return ResultBean
     */
    public static ResultBean error(String msg) {
        return error(-1, msg);
    }

}
