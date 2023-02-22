package com.dimple.fileuploaddownload.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * FileController
 *
 * @author BianXiaofeng
 * @date 12/8/2022 10:16 AM
 */
@Data
@Builder
public class ResponseResult<T> {

    /**
     * response timestamp
     */
    private long timestamp;

    /**
     * response status.
     * 200 -> OK
     */
    private int status;

    /**
     * response message
     */
    private String message;

    /**
     * response data
     */
    private T data;

    /**
     * success response with data wrapper
     *
     * @param data the response data
     * @param <T>  the type of data class
     * @return the response result
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder()
                .status(HttpStatus.OK.value())
                .message("OK")
                .data(data)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * error response with data wrapper
     *
     * @param message the error message
     * @param <T>     the type of result
     * @return error response result
     */
    public static <T> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * error response with result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(System.currentTimeMillis())
                .build();
    }
}