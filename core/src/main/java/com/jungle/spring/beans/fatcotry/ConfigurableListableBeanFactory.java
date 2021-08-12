package com.jungle.spring.beans.fatcotry;

import cn.hutool.core.bean.BeanException;
import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.config.AutowireCapableBeanFactory;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.config.BeanPostProcessor;
import com.jungle.spring.beans.fatcotry.config.ConfigurableBeanFactory;

/**
 * 提供修改和分析Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, ListableBeanFactory, AutowireCapableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
