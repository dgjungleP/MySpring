package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
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
