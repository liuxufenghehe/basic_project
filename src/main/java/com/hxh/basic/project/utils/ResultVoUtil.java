package com.hxh.basic.project.utils;


import com.hxh.basic.project.enums.ResultEnum;
import com.hxh.basic.project.vo.ResultVo;

/**
 * @author huangxunhui
 * Date: Created in 18/8/20 上午11:05
 * Utils: Intellij Idea
 * Description: 返回数据工具类
 */
public class ResultVoUtil {

    /**
     * 私有化工具类 防止被实例化
     * j
     */
    private ResultVoUtil() {}

    /**
     * 成功
     * @param object 需要返回的数据
     * @return data
     */
    public static ResultVo success(Object object) {
        ResultVo result = new ResultVo();
        result.setCode(0);
        result.setMessage("ok");
        result.setData(object);
        return result;
    }

    /**
     * 成功
     * @return 返回空
     */
    public static ResultVo success() {
        return success(null);
    }

    /**
     * 错误
     * @param resultEnum 错误枚举类
     * @return 错误信息
     */
    public static ResultVo error(ResultEnum resultEnum) {
        ResultVo result = new ResultVo();
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
    public static ResultVo error(Integer code, String msg) {
        ResultVo result = new ResultVo();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    /**
     * 错误
     * @param msg 错误信息
     * @return ResultBean
     */
    public static ResultVo error(String msg) {
        return error(-1, msg);
    }

}
