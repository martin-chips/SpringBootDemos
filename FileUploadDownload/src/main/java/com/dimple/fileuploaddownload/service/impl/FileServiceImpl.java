package com.dimple.fileuploaddownload.service.impl;

import cn.hutool.core.io.FileUtil;
import com.dimple.fileuploaddownload.common.CommonConstants;
import com.dimple.fileuploaddownload.service.FileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * FileServiceImpl
 *
 * @author BianXiaofeng
 * @date 12/8/2022 10:27 AM
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {
    @SneakyThrows
    @Override
    public void upload(MultipartFile file) {
        File uploadDir = FileUtil.mkdir(CommonConstants.FILE_UPLOAD_DIR);
        log.info("the file {} will be uploaded to {}.", file.getName(), uploadDir.getAbsolutePath());
        File localFile = new File(CommonConstants.FILE_UPLOAD_DIR + File.separator + file.getOriginalFilename());
        file.transferTo(localFile);
    }
}
