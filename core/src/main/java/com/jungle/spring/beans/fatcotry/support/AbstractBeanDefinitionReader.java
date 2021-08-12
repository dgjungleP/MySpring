package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.core.io.DefaultResourceLoader;
import com.jungle.spring.core.io.ResourceLoader;

/**
 * 抽象bean定义读取类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    private ResourceLoader loader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader loader) {
        this.registry = registry;
        this.loader = loader;
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    @Override
    public BeanDefinitionRegistry getRegister() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.loader;
    }
}
