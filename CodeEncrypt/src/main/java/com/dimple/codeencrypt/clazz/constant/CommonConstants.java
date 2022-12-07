package com.dimple.codeencrypt.clazz.constant;

import java.util.Arrays;
import java.util.List;

/**
 * CommonConstants
 *
 * @author BianXiaofeng
 * @date 2022/11/17 16:27
 */
public class CommonConstants {
    /**
     * code encrypt secret key
     */
    public static final String SECRET_KEY = "96E1327CE14CFEC20843AF42D75177229DE22D53BD3770A6326DDFEA8A0B3691X1A0F3NG1668673832056";
    /**
     * the delimiter for the secret key
     */
    public static final String KEY_SPLIT_KEY = "X1A0F3NG";
    /**
     * the code encrypt suffix for the encrypted class file
     */
    public static final String ENCRYPTED_CLASS_SUFFIX = ".bxf";
    /**
     * thr folder which contains the encrypted class file
     */
    public static final String ENCRYPT_CLASS_ROOT_DIR = "META-INF/services/";
    /**
     * need encrypt class reference
     */
    public static final List<String> NEED_ENCRYPT_CLASS_REFERENCE = Arrays.asList("com.dimple.codeencrypt.web.service.impl.UserServiceImpl");
}
