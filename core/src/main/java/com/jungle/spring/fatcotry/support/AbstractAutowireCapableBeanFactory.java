package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

/**
 * Bean工厂Bean实例化类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 通过Bean注册名称和Bean定义信息生成对应的Bean实例类
     *
     * @param beanName       Bean注册名称
     * @param beanDefinition Bean定义信息
     * @return Bean实例类
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
