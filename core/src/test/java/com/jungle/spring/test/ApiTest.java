package com.jungle.spring.test;

import com.jungle.spring.BeanDefinition;
import com.jungle.spring.BeanFactory;
import com.jungle.spring.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testBeanFactory() {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService service = (UserService) beanFactory.getBean("userService");
        service.queryUserInfo();
    }
}
