package com.jungle.spring.fatcotry.config;

/**
 * 单例类注册接口
 */
public interface SingletonBeanRegistry {
    /**
     * 通过BeanName获取Bean的单例实现
     *
     * @param beanName bean的注册名称
     * @return Bean对象
     */
    Object getSingleton(String beanName);
}
