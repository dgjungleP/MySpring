package com.jungle.spring.context.support;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.support.BeanDefinitionReader;
import com.jungle.spring.beans.fatcotry.support.DefaultListableBeanFactory;
import com.jungle.spring.beans.fatcotry.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinition(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] locations = getConfigLocations();
        if (null != locations) {
            try {
                beanDefinitionReader.loadBeanDefinitions(locations);
            } catch (BeansException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract String[] getConfigLocations();
}
