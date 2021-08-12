package com.jungle.spring.test;

import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.fatcotry.BeanFactory;
import com.jungle.spring.beans.fatcotry.support.DefaultListableBeanFactory;
import com.jungle.spring.beans.fatcotry.xml.XmlBeanDefinitionReader;
import com.jungle.spring.test.bean.UserService;
import org.junit.Test;

public class ApiTest {


    @Test
    public void test_xml() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}
