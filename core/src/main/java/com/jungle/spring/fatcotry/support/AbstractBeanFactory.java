package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.BeanFactory;
import com.jungle.spring.fatcotry.config.BeanDefinition;

/**
 * 抽象Bean工厂模板类
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);

    }

    /**
     * 通过Bean名称获取Bean的定义信息
     *
     * @param beanName Bean注册名称
     * @return Bean定义信息
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 通过Bean定义信息和Bean名称生成Bean实例对象
     *
     * @param beanName       Bean注册名称
     * @param beanDefinition Bean定义信息
     * @return Bean实例对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
