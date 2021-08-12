package com.jungle.spring.beans.fatcotry.config;

import com.jungle.spring.beans.fatcotry.HierarchicalBeanFactory;

/**
 * 获取BeanPostProcess 和BeanClassLoader的配置化接口
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    String SCOPE_SINGLETON = "";
    String SCOPE_PROTOTYPE = "";
}
