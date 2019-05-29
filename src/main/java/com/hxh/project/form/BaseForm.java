package com.hxh.project.form;

import org.springframework.beans.BeanUtils;

/**
 * @author huangxunhui
 * Date: Created in 2019-05-29 17:02
 * Utils: Intellij Idea
 * Description: 通用表单
 */
public interface BaseForm<T> {

    /**
     * 获取实例
     * @param form 表单对象
     * @param clazz 表单对应的实体类
     * @return 返回实体类
     * @throws IllegalAccessException 异常
     * @throws InstantiationException 异常
     */
    default T getEntity(Object form , Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        BeanUtils.copyProperties(form , t);
        return t;
    }

}
