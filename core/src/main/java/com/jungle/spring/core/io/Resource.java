package com.jungle.spring.core.io;

import org.apache.tools.ant.input.InputRequest;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源类
 */
public interface Resource {

    /**
     * 获取资源文件
     *
     * @return 文件输入流
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
