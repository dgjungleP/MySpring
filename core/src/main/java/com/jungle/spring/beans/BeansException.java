package com.jungle.spring.beans;

public class BeansException extends Exception {
    public BeansException(String message, Throwable e) {
        super(message, e);
    }

    public BeansException(String message) {
        super(message);
    }
}
