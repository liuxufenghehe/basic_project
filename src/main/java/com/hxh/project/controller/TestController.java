package com.hxh.project.controller;


import com.hxh.project.dto.ResultBean;
import com.hxh.project.enums.ResultEnum;
import com.hxh.project.utils.ResultUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huangxunhui
 * @since 2019-05-29
 */
@RestController
@RequestMapping("/Test")
public class TestController {

    @PostMapping("/add")
    public ResultBean add(){
        return ResultUtil.error(ResultEnum.ADD_ERROR);
    }

    @PutMapping("/update")
    public ResultBean update(){
        return ResultUtil.error(ResultEnum.UPDATE_ERROR);
    }

    @GetMapping("/get")
    public ResultBean get(){
        return ResultUtil.error(ResultEnum.GET_ERROR);
    }

    @DeleteMapping("/delete")
    public ResultBean delete(){
        return ResultUtil.error(ResultEnum.DELETE_ERROR);
    }

}
