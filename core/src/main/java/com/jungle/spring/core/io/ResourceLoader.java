package com.jungle.spring.core.io;

/**
 * 资源加载器
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 集中式处理获取资源
     *
     * @param location 地址
     * @return
     */
    Resource getResource(String location);
}
