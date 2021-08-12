package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.fatcotry.config.BeanDefinition;

/**
 * Bean定义注册接口
 */
public interface BeanDefinitionRegistry {
    /**
     * 将Bean通过Bean名称和Bean定义进行注册使用
     *
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containBeanDefinition(String beanName);
}
