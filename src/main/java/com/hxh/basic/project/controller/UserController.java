package com.hxh.basic.project.controller;


import com.hxh.basic.project.enums.ResultEnum;
import com.hxh.basic.project.form.user.AddUserForm;
import com.hxh.basic.project.form.user.ListUserForm;
import com.hxh.basic.project.service.IUserService;
import com.hxh.basic.project.utils.ResultVoUtil;
import com.hxh.basic.project.vo.ResultVo;
import com.hxh.basic.project.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangxunhui
 * @date Created in 2020/3/6 4:30 下午
 * Utils: Intellij Idea
 * Description: 用户前端控制器
 */
@RestController
@Api(tags = "用户")
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    /**
     * 添加用户
     * @param userForm 表单数据
     * @return 成功或者失败
     */
    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public ResultVo addUser(@Validated @RequestBody AddUserForm userForm){
        if(userService.addUser(userForm)){
            return ResultVoUtil.success();
        }else{
            return ResultVoUtil.error(ResultEnum.ADD_ERROR);
        }
    }

    /**
     * 获取用户列表
     * @param listUserForm 表单数据
     * @return 用户列表
     */
    @ApiOperation("获取用户列表")
    @GetMapping("/listUser")
    @ApiResponses(
            @ApiResponse(code = 200, message = "操作成功", response = UserVo.class)
    )
    public ResultVo listUser(@Validated ListUserForm listUserForm){
        return ResultVoUtil.success(userService.listUser(listUserForm));
    }

    /**
     * 删除用户
     * @param id 用户编号
     * @return 成功或者失败
     */
    @ApiOperation("删除用户")
    @DeleteMapping("/deleteUser/{id}")
    public ResultVo deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return ResultVoUtil.success();
    }
}
