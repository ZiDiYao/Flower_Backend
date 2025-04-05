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

        // 使用项目根路径拼接 uploads 文件夹
        String projectPath = System.getProperty("user.dir");  // FlowerBackEndDemo 根目录
        File uploadPath = new File(projectPath, uploadDir);

        // 自动创建 uploads 目录（如不存在）
        if (!uploadPath.exists()) {
            boolean created = uploadPath.mkdirs();
            if (!created) {
                throw new IOException("Failed to create upload directory.");
            }
        }

        // 生成唯一文件名
        String originalFilename = file.getOriginalFilename();
        String ext = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";
        String filename = UUID.randomUUID().toString() + ext;

        File dest = new File(uploadPath, filename);
        file.transferTo(dest);

        System.out.println("✅ Image saved to: " + dest.getAbsolutePath());
        return filename;
    }
}
