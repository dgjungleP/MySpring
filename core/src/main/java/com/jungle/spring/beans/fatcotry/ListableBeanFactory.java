package com.jungle.spring.beans.fatcotry;

import java.util.List;

/**
 * bean 工厂扩展接口
 */
public interface ListableBeanFactory extends BeanFactory {
    List<?> getBeansOfType(Class<?> type);

    List<String> getBeanDefinitionNames();
}
