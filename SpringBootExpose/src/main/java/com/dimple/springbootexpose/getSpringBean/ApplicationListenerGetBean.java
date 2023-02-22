package com.dimple.springbootexpose.getSpringBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * ApplicationListenerGetBean
 *
 * @author Dimple
 * @date 2/6/2023 4:07 PM
 */
public class ApplicationListenerGetBean implements ApplicationListener<ContextRefreshedEvent> {
    ApplicationContext applicationContext;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
    }
}
