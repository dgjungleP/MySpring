package com.jungle.spring.fatcotry.config;


/**
 * 类定义类
 */
public class BeanDefinition {
    private Class beanClass;


    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
