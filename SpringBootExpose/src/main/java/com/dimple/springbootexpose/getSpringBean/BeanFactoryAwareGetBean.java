package com.dimple.springbootexpose.getSpringBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * BeanFactoryAwareGetBean
 *
 * @author Dimple
 * @date 2/6/2023 4:06 PM
 */
public class BeanFactoryAwareGetBean implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        this.beanFactory.getBean("test");
    }
}
