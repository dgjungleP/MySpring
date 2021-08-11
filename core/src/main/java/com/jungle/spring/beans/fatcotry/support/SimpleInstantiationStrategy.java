package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK生成实现
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /**
     * @param beanDefinition Bean 对象定义
     * @param beanName       Bean对象名称
     * @param ctor           Bean对象构造器
     * @param args           Bean对象构造参数
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            if (null != ctor) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + " ]", e);
        }
    }
}
