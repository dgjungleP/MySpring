package com.jungle.spring.beans.fatcotry.config;

import cn.hutool.core.bean.BeanException;

/**
 * 实例化Bean对象的扩展点
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象初始化之前，执行方法
     *
     * @param bean     bean对象
     * @param beanName bean对象名称
     * @return
     * @throws BeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeanException;

    /**
     * 在Bean对象初始化之后，执行方法
     *
     * @param bean     bean对象
     * @param beanName bean对象名称
     * @return
     * @throws BeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeanException;
}

