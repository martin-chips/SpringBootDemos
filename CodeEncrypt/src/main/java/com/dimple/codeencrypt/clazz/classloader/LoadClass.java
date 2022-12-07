package com.dimple.codeencrypt.clazz.classloader;

import com.dimple.codeencrypt.clazz.constant.CommonConstants;

import java.lang.reflect.Method;

/**
 * LoadClass
 *
 * @author BianXiaofeng
 * @date 2022/11/17 11:32
 */
public class LoadClass {
    public static void main(String[] args) throws ClassNotFoundException {
        CustomerClassLoader myClassLoader = new CustomerClassLoader(CommonConstants.SECRET_KEY);
        for (String className : CommonConstants.NEED_ENCRYPT_CLASS_REFERENCE) {
            Class<?> clazz = myClassLoader.findClass(className);
            System.out.println(clazz.getName());
            Method[] methods = clazz.getMethods();
            for (Method me : methods) {
                System.out.println(me);
            }
        }
    }
}
