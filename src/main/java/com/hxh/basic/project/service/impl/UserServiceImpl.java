package com.hxh.basic.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxh.basic.project.entity.User;
import com.hxh.basic.project.enums.ResultEnum;
import com.hxh.basic.project.exception.CustomException;
import com.hxh.basic.project.form.user.AddUserForm;
import com.hxh.basic.project.form.user.ListUserForm;
import com.hxh.basic.project.mapper.UserMapper;
import com.hxh.basic.project.service.IUserService;
import com.hxh.basic.project.utils.MethodUtil;
import com.hxh.basic.project.vo.PageVo;
import com.hxh.basic.project.vo.UserVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author huangxunhui
 * @date Created in 2020/3/6 4:50 下午
 * Utils: Intellij Idea
 * Description: 用户服务实现类
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private UserMapper userMapper;

    /**
     * 添加用户
     * @param userForm 表单数据
     * @return true 或者 false
     */
    @Override
    public boolean addUser(AddUserForm userForm) {
        return save(userForm.buildEntity());
    }

    /**
     * 获取用户列表
     * @param listUserForm 表单数据
     * @return 用户列表
     */
    @Override
    public PageVo<UserVo> listUser(ListUserForm listUserForm) {
        PageVo<UserVo> pageVo = new PageVo<UserVo>().setCurrentAndSize(listUserForm);
        pageVo.setTotal(countUser(listUserForm.getStatus()));
        pageVo.setRecords(userMapper.listUser(listUserForm.calcCurrent()));
        return pageVo;
    }

    /**
     * 删除用户
     * @param id id
     */
    @Override
    public void deleteUser(String id) {
        // 如果删除失败抛出异常。 -- 演示而已不推荐这样干
        if(!removeById(id)){
            throw new CustomException(ResultEnum.DELETE_ERROR, MethodUtil.getLineInfo());
        }
    }

    /**
     * 获取用户数量
     * @param status 状态
     * @return 用户数量
     */
    private Integer countUser(String status){
        return count(new QueryWrapper<User>().eq("status",status));
    }

}
