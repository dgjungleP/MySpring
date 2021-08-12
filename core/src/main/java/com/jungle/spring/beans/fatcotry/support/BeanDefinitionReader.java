package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.core.io.Resource;
import com.jungle.spring.core.io.ResourceLoader;

import java.util.List;

/**
 * bean对象定义信息读取器
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegister();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
