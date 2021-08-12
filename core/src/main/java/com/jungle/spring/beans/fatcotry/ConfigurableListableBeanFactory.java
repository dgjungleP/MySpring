package com.jungle.spring.beans.fatcotry;

import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.config.ConfigurableBeanFactory;

/**
 * 提供修改和分析Bean以及预先实例化的操作接口
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName);
}
