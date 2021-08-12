package com.jungle.spring.context;

import cn.hutool.core.bean.BeanException;
import com.jungle.spring.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeanException
     */
    void refresh() throws BeansException;

    void registerShutDownHook();

    void close();
}
