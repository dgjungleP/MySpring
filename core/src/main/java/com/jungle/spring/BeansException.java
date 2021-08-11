package com.jungle.spring;

public class BeansException extends Exception {
    public BeansException(String message, Throwable e) {
        super(message, e);
    }

    public BeansException(String message) {
        super(message);
    }
}
