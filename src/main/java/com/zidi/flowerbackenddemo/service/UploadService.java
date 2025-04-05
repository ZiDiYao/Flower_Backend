package com.zidi.flowerbackenddemo.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    public String saveFile(MultipartFile file) throws IOException;
}
