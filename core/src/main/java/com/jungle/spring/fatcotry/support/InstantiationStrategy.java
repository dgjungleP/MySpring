package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean对象生成策略
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;

}
