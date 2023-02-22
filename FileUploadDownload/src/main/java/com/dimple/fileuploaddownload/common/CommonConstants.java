package com.dimple.fileuploaddownload.common;

import cn.hutool.core.util.StrUtil;

import java.util.Properties;

/**
 * CommonConstants
 *
 * @author BianXiaofeng
 * @date 12/8/2022 10:28 AM
 */
public class CommonConstants {
    /**
     * the file upload path
     */
    public static final String FILE_UPLOAD_DIR;

    static {
        Properties systemProperties = System.getProperties();
        String osName = systemProperties.getProperty("os.name");
        if (StrUtil.containsIgnoreCase(osName, "windows")) {
            FILE_UPLOAD_DIR = "D://";
        } else {
            FILE_UPLOAD_DIR = "/tmp";
        }
    }
}
