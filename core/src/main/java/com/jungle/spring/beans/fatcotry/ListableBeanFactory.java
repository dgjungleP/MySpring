package com.jungle.spring.beans.fatcotry;

import com.jungle.spring.beans.BeansException;

import java.util.List;
import java.util.Map;

/**
 * bean 工厂扩展接口
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type);

    List<String> getBeanDefinitionNames();
}
