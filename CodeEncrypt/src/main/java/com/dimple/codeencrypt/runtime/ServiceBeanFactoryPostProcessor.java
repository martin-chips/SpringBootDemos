package com.dimple.codeencrypt.runtime;

import com.dimple.codeencrypt.clazz.constant.CommonConstants;
import com.dimple.codeencrypt.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * ServiceBeanFactoryPostProcessor
 *
 * @author BianXiaofeng
 * @date 2022/11/17 17:55
 */
@Component
public class ServiceBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        registerBean(configurableListableBeanFactory, CommonConstants.SECRET_KEY);
    }

    private void registerBean(ConfigurableListableBeanFactory configurableListableBeanFactory, String secretKey) {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.getPropertyValues().add("serviceClz", UserService.class);
        definition.getPropertyValues().add("serviceImplClzName", "com.dimple.codeencrypt.web.service.impl.UserServiceImpl");
        definition.getPropertyValues().add("secretKey", secretKey);
        definition.setBeanClass(ServiceFactoryBean.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        String beanId = StringUtils.uncapitalize(UserService.class.getSimpleName());
        defaultListableBeanFactory.registerBeanDefinition(beanId, definition);
    }
}
