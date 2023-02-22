package com.dimple.springbootexpose.getSpringBean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextAwareGetBean
 *
 * @author Dimple
 * @date 2/6/2023 4:06 PM
 */
public class ApplicationContextAwareGetBean implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        this.context.getBean("test");
    }
}
