package com.fourjuniors.juniors.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String getObjectUrl(String key);
    String putObject(final MultipartFile multipartFile);
    void deleteObject(String key);
}
