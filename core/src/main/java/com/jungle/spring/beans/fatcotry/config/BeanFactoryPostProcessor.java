package com.jungle.spring.beans.fatcotry.config;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.ConfigurableListableBeanFactory;

/**
 * Bean实例化之前的扩展点
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition都加载完之后，实例化Bean对象之前，提供修改BeanDefinition 属性的扩展点
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
