package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.fatcotry.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例类注册类默认实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 单例类容器
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例类到单例类容器中
     *
     * @param beanName        单例类名称
     * @param singletonObject 单例类实例
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
