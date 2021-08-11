package com.jungle.spring.beans;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean实例对象的属性集合
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    /**
     * 向属性集合总加入属性
     *
     * @param propertyValue 属性值
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    /**
     * 获取属性集合的数组形式
     *
     * @return 属性集合的数组
     */
    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 获取属性集合中执行的属性值
     *
     * @param propertyName 属性名称
     * @return 属性值对象 可能为null；
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}
