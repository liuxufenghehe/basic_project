package com.hxh.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangxunhui
 * Date: Created in 2018-12-17 11:05
 * Utils: Intellij Idea
 * Description: 固定返回格式
 */
@Data
@ApiModel("固定返回格式")
public class ResultBean {

    /**
     * 错误码
     */
    @ApiModelProperty("错误码")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 具体的内容
     */
    @ApiModelProperty("具体的内容")
    private Object data;

}
