package com.dimple.fileuploaddownload.controller;

import com.dimple.fileuploaddownload.common.ResponseResult;
import com.dimple.fileuploaddownload.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileController
 *
 * @author BianXiaofeng
 * @date 12/8/2022 10:16 AM
 */
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping
    public ResponseResult<String> upload(MultipartFile file) {
        fileService.upload(file);
        return ResponseResult.success("success");
    }
}
