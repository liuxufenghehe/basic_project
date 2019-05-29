package com.hxh.project.aop;

import com.hxh.project.dto.ResultBean;
import com.hxh.project.enums.ResultEnum;
import com.hxh.project.exception.CustomException;
import com.hxh.project.utils.EnumUtil;
import com.hxh.project.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;


/**
 * @author 黄训辉
 * Date: Created in 2018/3/22 11:02
 * Utils: Intellij Idea
 * Description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {

    private static final String SEPARATOR = "<===================================================================================>";

    private static final String ERROR_MSG = "【错误信息】";

    @ExceptionHandler(value = CustomException.class)
    public ResultBean processException(CustomException e) {
        log.error(SEPARATOR);
        log.error("【方法】" + e.getMethod());
        log.error("【时间】" + e.getTime());
        log.error(ERROR_MSG + e.getLocalizedMessage());
        log.error(SEPARATOR);
        return ResultUtil.error(Objects.requireNonNull(EnumUtil.getByCode(e.getCode(), ResultEnum.class)));
    }

    /**
     * 用于处理通用异常(主要用于参数校验)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBean bindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResultUtil.error(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResultBean methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error(SEPARATOR);
        log.error(ERROR_MSG + e.getLocalizedMessage());
        log.error(SEPARATOR);
        return ResultUtil.error(ResultEnum.ARGUMENT_TYPE_MISMATCH);
    }

    /**
     * 参数格式错误
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultBean httpMessageNotReadable(HttpMessageNotReadableException e) {
        log.error(SEPARATOR);
        log.error(ERROR_MSG + e.getLocalizedMessage());
        log.error(SEPARATOR);
        return ResultUtil.error(ResultEnum.FORMAT_ERROR);
    }

    /**
     * 通用异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBean exception(Exception e) {
        e.printStackTrace();
        return ResultUtil.error(ResultEnum.UNKNOWN_EXCEPTION);
    }
}
