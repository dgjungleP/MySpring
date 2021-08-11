package com.jungle.spring.test;

import com.jungle.spring.beans.BeanReference;
import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.PropertyValue;
import com.jungle.spring.beans.PropertyValues;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.support.DefaultListableBeanFactory;
import com.jungle.spring.test.bean.UserDao;
import com.jungle.spring.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        propertyValues.addPropertyValue(new PropertyValue("id", "10002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();
    }

}
