package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.BeanFactory;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.config.BeanPostProcessor;
import com.jungle.spring.beans.fatcotry.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象Bean工厂模板类
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);

    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) getBean(beanName);
    }

    /**
     * 通过Bean名称获取Bean的定义信息
     *
     * @param beanName Bean注册名称
     * @return Bean定义信息
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

//    /**
//     * 通过Bean定义信息和Bean名称生成Bean实例对象
//     *
//     * @param beanName       Bean注册名称
//     * @param beanDefinition Bean定义信息
//     * @return Bean实例对象
//     * @throws BeansException
//     */
//    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    /**
     * 通过Bean定义信息和Bean名称生成Bean实例对象
     *
     * @param beanName       Bean注册名称
     * @param beanDefinition Bean定义信息
     * @return Bean实例对象
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }
}
