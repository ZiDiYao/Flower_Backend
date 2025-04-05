package com.zidi.flowerbackenddemo.service.impl;

import com.zidi.flowerbackenddemo.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${upload.path}")
    private String uploadDir;

    @Override
    public String saveFile(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null ||
                !(contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
            return null;
        }

        String extension = contentType.equals("image/jpeg") ? ".jpg" : ".png";
        String fileName = UUID.randomUUID() + extension;

        try {
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            File destination = new File(dir, fileName);
            file.transferTo(destination);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
