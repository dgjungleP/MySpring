package com.jungle.spring.fatcotry.support;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean工厂Bean实例化类
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
//    /**
//     * 通过Bean注册名称和Bean定义信息生成对应的Bean实例类
//     *
//     * @param beanName       Bean注册名称
//     * @param beanDefinition Bean定义信息
//     * @return Bean实例类
//     * @throws BeansException
//     */
//    @Override
//    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
//        Object bean;
//        try {
//            bean = beanDefinition.getBeanClass().newInstance();
//        } catch (InstantiationException | IllegalAccessException e) {
//            throw new BeansException("Instantiation of bean failed", e);
//        }
//        addSingleton(beanName, bean);
//        return bean;
//    }

    /**
     * 通过Bean注册名称和Bean定义信息生成对应的Bean实例类
     *
     * @param beanName       Bean注册名称
     * @param beanDefinition Bean定义信息
     * @return Bean实例类
     * @throws BeansException
     */
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) throws BeansException {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }
}
