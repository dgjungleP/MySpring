package com.jungle.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Bean 工厂类
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 通过名称获取Bean对象
     *
     * @param beanName bean对象名称
     * @return bean对象
     */
    public Object getBean(String beanName) {
        return beanDefinitionMap.get(beanName).getBean();
    }

    /**
     * 将bean对象注入到Bean工厂中
     *
     * @param name           Bean对象名称标识
     * @param beanDefinition Bean对象元信息
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
