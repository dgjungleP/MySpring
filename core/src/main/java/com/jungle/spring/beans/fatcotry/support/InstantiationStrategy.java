package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean对象生成策略
 */
public interface InstantiationStrategy {

    /**
     * @param beanDefinition Bean 对象定义
     * @param beanName       Bean对象名称
     * @param ctor           Bean对象构造器
     * @param args           Bean对象构造参数
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
