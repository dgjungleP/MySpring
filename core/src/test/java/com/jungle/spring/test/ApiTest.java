package com.jungle.spring.test;

import com.jungle.spring.BeansException;
import com.jungle.spring.fatcotry.config.BeanDefinition;
import com.jungle.spring.fatcotry.BeanFactory;
import com.jungle.spring.fatcotry.support.DefaultListableBeanFactory;
import com.jungle.spring.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();
        UserService service_singleton = (UserService) beanFactory.getBean("userService");
        service_singleton.queryUserInfo();
    }

}
