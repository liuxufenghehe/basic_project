package com.hxh.basic.project.form.user;

import com.hxh.basic.project.entity.User;
import com.hxh.basic.project.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author huangxunhui
 * Date: Created in 2020/3/6 3:28 下午
 * Utils: Intellij Idea
 * Description: 添加用户需要的表单数据
 */
@Data
@ApiModel("添加用户需要的表单数据")
@EqualsAndHashCode(callSuper = false)
public class AddUserForm extends BaseForm<User> {

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    @NotEmpty(message = "昵称不能为为空")
    @Length(min = 1 , max = 10 , message = "昵称长度限制为1~10")
    private String nickname;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    @Past(message = "生日时间必须小于当前时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 1 , max = 16 , message = "用户名长度限制为1~16")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[._~!@#$^&*])[A-Za-z0-9._~!@#$^&*]{8,20}$" , message = "密码不符合规范")
    private String password;

    /**
     * 构造实体
     * @return 实体对象
     */
    @Override
    public User buildEntity() {
        User user = new User();
        BeanUtils.copyProperties(this,user);
        return user;
    }
}
