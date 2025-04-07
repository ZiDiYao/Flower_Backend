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

    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty.");
        }
        String projectPath = System.getProperty("user.dir");
        File uploadPath = new File(projectPath, uploadDir);

        if (!uploadPath.exists()) {
            boolean created = uploadPath.mkdirs();
            if (!created) {
                throw new IOException("Failed to create upload directory.");
            }
        }

        String originalFilename = file.getOriginalFilename();
        String ext = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";
        String filename = UUID.randomUUID().toString() + ext;

        File dest = new File(uploadPath, filename);
        file.transferTo(dest);

        System.out.println("Image saved to: " + dest.getAbsolutePath());
        return filename;
    }
    @Override
    public String getUploadDir() {
        String projectPath = System.getProperty("user.dir");
        return new File(projectPath, uploadDir).getAbsolutePath();
    }

}
