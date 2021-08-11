package com.jungle.spring.fatcotry;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean 工厂类
 */
public interface BeanFactory {


    /**
     * 通过名称获取Bean对象
     *
     * @param beanName Bean对象名称
     * @param args     Bean构造阐述
     * @return bean对象
     */
    Object getBean(String beanName, Object[] args) throws BeansException;


}
