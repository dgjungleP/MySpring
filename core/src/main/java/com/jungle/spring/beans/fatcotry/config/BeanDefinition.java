package com.jungle.spring.beans.fatcotry.config;


import com.jungle.spring.beans.PropertyValue;
import com.jungle.spring.beans.PropertyValues;

/**
 * 类定义类
 */
public class BeanDefinition {
    private Class<?> beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this(beanClass);
        if (propertyValues != null) {
            this.propertyValues = propertyValues;
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
