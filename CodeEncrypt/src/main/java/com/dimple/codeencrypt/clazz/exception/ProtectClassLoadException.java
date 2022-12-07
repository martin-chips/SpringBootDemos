package com.dimple.codeencrypt.clazz.exception;

/**
 * ProtectClassLoadException
 *
 * @author BianXiaofeng
 * @date 2022/11/17 9:58
 */
public class ProtectClassLoadException extends RuntimeException {
    public ProtectClassLoadException(String message) {
        super(message);
    }

    public ProtectClassLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProtectClassLoadException(Throwable cause) {
        super(cause);
    }
}
