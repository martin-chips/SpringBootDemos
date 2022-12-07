package com.dimple.codeencrypt.clazz.classloader;

import com.dimple.codeencrypt.clazz.constant.CommonConstants;
import com.dimple.codeencrypt.clazz.exception.ProtectClassLoadException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

/**
 * CustomerClassLoader
 *
 * @author BianXiaofeng
 * @date 2022/11/17 9:34
 */
@Slf4j
public class CustomerClassLoader extends ClassLoader {

    private String secretKey;


    public CustomerClassLoader(String secretKey) {
        this.secretKey = secretKey;
    }


    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        // find if this class has already been loaded.
        Class<?> loadedClass = findLoadedClass(name);
        if (!Objects.isNull(loadedClass)) {
            // if this clas has been loaded, just return it.
            return loadedClass;
        }
        // parent load class
        loadedClass = parentLoadClass(this.getParent(), name);
        if (!Objects.isNull(loadedClass)) {
            return loadedClass;
        }
        return loadClassByDecrypt(name);
    }

    /**
     * load class by decrypt
     *
     * @param name need loaded class name
     * @return class
     */
    private Class<?> loadClassByDecrypt(String name) throws ClassNotFoundException {
        byte[] classByteData = getClassByteData(name);
        if (Objects.isNull(classByteData)) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classByteData, 0, classByteData.length);
    }

    /**
     * load clas byte stream
     *
     * @param className class name
     * @return
     */
    private byte[] getClassByteData(String className) {
        if (StringUtils.isEmpty(secretKey) || !secretKey.contains(CommonConstants.KEY_SPLIT_KEY) || secretKey.split(CommonConstants.KEY_SPLIT_KEY).length != 2) {
            throw new IllegalArgumentException("illegal secret key");
        }
        String classPath = CustomerClassLoader.class.getClassLoader().getResource("").getPath() + "/" + CommonConstants.ENCRYPT_CLASS_ROOT_DIR + "/" + className + CommonConstants.ENCRYPTED_CLASS_SUFFIX;
        try (InputStream inputStream = new FileInputStream(classPath); ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int length;
            String[] split = secretKey.split(CommonConstants.KEY_SPLIT_KEY);
            long key = Long.valueOf(split[1]);
            log.debug("key is {}", key);
            while ((length = inputStream.read()) != -1) {
                byte data = (byte) (length - key - secretKey.length());
                byteArrayOutputStream.write(data);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            log.debug("encrypt class {} failed.", className, e);
            throw new ProtectClassLoadException("Can't load class " + className);
        }
    }

    /**
     * load this class by parent classloader
     *
     * @param parent parent classloader
     * @param name   class name
     * @return
     */
    private Class<?> parentLoadClass(ClassLoader parent, String name) {
        Class<?> loadClass = null;
        try {
            loadClass = parent.loadClass(name);
        } catch (Exception ignore) {
            log.debug("parent load class {} failed.", name);
        }
        return loadClass;
    }
}
