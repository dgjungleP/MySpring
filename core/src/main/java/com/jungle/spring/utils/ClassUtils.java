package com.jungle.spring.utils;

public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
