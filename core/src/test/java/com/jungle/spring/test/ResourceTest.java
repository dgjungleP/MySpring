package com.jungle.spring.test;

import cn.hutool.core.io.IoUtil;
import com.jungle.spring.beans.fatcotry.config.BeanReference;
import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.PropertyValue;
import com.jungle.spring.beans.PropertyValues;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.support.DefaultListableBeanFactory;
import com.jungle.spring.core.io.DefaultResourceLoader;
import com.jungle.spring.core.io.Resource;
import com.jungle.spring.test.bean.UserDao;
import com.jungle.spring.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        this.resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

//    /**
//     * 远程链接有问题
//     */
//    @Test
//    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://raw.githubusercontent.com/dgjungleP/MySpring/main/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }

}
