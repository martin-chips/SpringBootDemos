package com.dimple.codeencrypt.clazz.utils;

import com.dimple.codeencrypt.clazz.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * EnCryptUtils
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:56
 */
@Slf4j
public class EnCryptUtils {

    /**
     * encrypt <code> classFileSrcPath</code> class file to <code>classFileDestPath</code>
     *
     * @param classFileSrcPath
     * @param classFileDestPath
     */
    public static void encrypt(String classFileSrcPath, String classFileDestPath) {
        try (FileInputStream fileInputStream = new FileInputStream(classFileSrcPath);
             FileOutputStream fileOutputStream = new FileOutputStream(classFileDestPath);) {
            int len;
            String[] split = CommonConstants.SECRET_KEY.split(CommonConstants.KEY_SPLIT_KEY);
            Long key = Long.valueOf(split[1]);
            while ((len = fileInputStream.read()) != -1) {
                byte data = (byte) (len + key + CommonConstants.SECRET_KEY.length());
                fileOutputStream.write(data);
            }
        } catch (Exception ignore) {
            log.warn("encrypt failed. src is {}, des is {}.", classFileSrcPath, classFileDestPath, ignore);
        }
    }

}
