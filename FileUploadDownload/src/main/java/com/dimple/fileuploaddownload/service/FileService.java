package com.dimple.fileuploaddownload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * FileService
 *
 * @author BianXiaofeng
 * @date 12/8/2022 10:26 AM
 */
public interface FileService {
    /**
     * save file to the local
     *
     * @param file the file
     */
    void upload(MultipartFile file);
}
