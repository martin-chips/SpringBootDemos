package com.dimple.codeencrypt.runtime;

import com.dimple.codeencrypt.clazz.classloader.CustomerClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * ServiceFactory
 *
 * @author BianXiaofeng
 * @date 2022/11/17 17:58
 */
public class ServiceFactory {
    public static Object create(String secretKey, String serviceImplClzName, ApplicationContext applicationContext) throws Exception {
        CustomerClassLoader customerClassLoader = new CustomerClassLoader(secretKey);
        Class clz = customerClassLoader.loadClass(serviceImplClzName);
        return createBean(clz, applicationContext);
    }


    private static Object createBean(Class targetClz, ApplicationContext context) throws Exception {
        Object obj = targetClz.newInstance();
        Field[] fields = targetClz.getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                boolean hasAnnotation = field.isAnnotationPresent(Autowired.class);
                if (hasAnnotation) {
                    setField(context, obj, field);
                } else {
                    hasAnnotation = field.isAnnotationPresent(Resource.class);
                    if (hasAnnotation) {
                        setField(context, obj, field);
                    }
                }
            }
        }

        return obj;
    }

    public static void setField(ApplicationContext context, Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, context.getBean(field.getType()));
    }
}
