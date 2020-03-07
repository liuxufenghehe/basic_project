package com.hxh.basic.project.form.user;

import com.hxh.basic.project.form.PageForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * @author huangxunhui
 * Date: Created in 2020/3/6 4:04 下午
 * Utils: Intellij Idea
 * Description: 获取用户列表需要的表单数据
 */
@Data
@ApiModel("获取用户列表需要的表单数据")
@EqualsAndHashCode(callSuper = false)
public class ListUserForm extends PageForm<ListUserForm> {

    /**
     * 用户状态
     */
    @ApiModelProperty("用户状态")
    @NotEmpty(message = "用户状态不能为空")
    @Range(min =  -1 , max = 1 , message = "用户状态有误")
    private String status;

}
