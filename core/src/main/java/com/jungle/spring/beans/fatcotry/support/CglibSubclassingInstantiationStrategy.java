package com.jungle.spring.beans.fatcotry.support;

import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * Cglib生成实现
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    /**
     * @param beanDefinition Bean 对象定义
     * @param beanName       Bean对象名称
     * @param ctor           Bean对象构造器
     * @param args           Bean对象构造参数
     * @return
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);

    }


}
