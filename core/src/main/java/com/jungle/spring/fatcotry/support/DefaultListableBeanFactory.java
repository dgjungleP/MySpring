package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心实现类
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * @param beanName Bean注册名称
     * @return
     * @throws BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named " + beanName + " is defined");
        }
        return beanDefinition;
    }

    /**
     * @param beanName       Bean名称
     * @param beanDefinition Bean定义
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}