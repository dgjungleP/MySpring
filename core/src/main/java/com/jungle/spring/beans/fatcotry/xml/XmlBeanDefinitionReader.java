package com.jungle.spring.beans.fatcotry.xml;

import cn.hutool.core.bean.BeanException;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.jungle.spring.beans.BeansException;
import com.jungle.spring.beans.PropertyValue;
import com.jungle.spring.beans.fatcotry.config.BeanDefinition;
import com.jungle.spring.beans.fatcotry.config.BeanReference;
import com.jungle.spring.beans.fatcotry.support.AbstractBeanDefinitionReader;
import com.jungle.spring.beans.fatcotry.support.BeanDefinitionRegistry;
import com.jungle.spring.core.io.Resource;
import com.jungle.spring.core.io.ResourceLoader;
import com.sun.deploy.util.Base64Wrapper;
import com.sun.deploy.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 通过xml读取bean定义信息
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader loader) {
        super(registry, loader);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 真是的执行LoadBeanDefinition的过程
     *
     * @param inputStream 输入流
     * @throws ClassNotFoundException
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element rootElement = document.getDocumentElement();
        NodeList childNodes = rootElement.getChildNodes();
        int limit = childNodes.getLength();
        for (int i = 0; i < limit; i++) {
            Node item = childNodes.item(i);
            if (!(item instanceof Element)) {
                continue;
            }
            if (!"bean".equals(item.getNodeName())) {
                continue;
            }
            //解析xml标签
            Element bean = (Element) item;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            //获取class
            Class<?> clazz = Class.forName(className);
            //优先级 id>name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            //开始真实的Bean定义
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            //读取属性值开始填充
            NodeList propertyNodeList = bean.getChildNodes();
            int childNumber = propertyNodeList.getLength();
            for (int j = 0; j < childNumber; j++) {
                if (!(propertyNodeList.item(j) instanceof Element)) {
                    continue;
                }
                if (!"property".equals(propertyNodeList.item(j).getNodeName())) {
                    continue;
                }
                //开始解析标签
                Element property = (Element) propertyNodeList.item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                Object value = StrUtil.isNotBlank(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegister().containBeanDefinition(beanName)) {
                throw new BeanException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegister().registerBeanDefinition(beanName, beanDefinition);
        }

    }
}
