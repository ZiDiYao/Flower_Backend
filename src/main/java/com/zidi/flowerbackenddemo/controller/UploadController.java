package com.zidi.flowerbackenddemo.controller;

import com.zidi.flowerbackenddemo.dto.FlowerResultByPhoto;
import com.zidi.flowerbackenddemo.service.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.zidi.flowerbackenddemo.Ml.MLClient;



import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService fileUploadService;

    public UploadController(UploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * Handles POST request to upload an image file and analyze it via ML
     * Endpoint: POST /api/upload/image
     */
    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        System.out.println("Received image upload request");
        System.out.println("File name: " + file.getOriginalFilename());
        System.out.println("Content type: " + file.getContentType());
        System.out.println("File size: " + file.getSize() + " bytes");

        if (file.isEmpty()) {
            System.out.println("Upload failed: file is empty");
            return ResponseEntity.badRequest().body("Upload failed: file is empty");
        }

        String fileName = fileUploadService.saveFile(file);
        if (fileName == null) {
            System.out.println("Upload failed: unsupported file type or saving error");
            return ResponseEntity.badRequest().body("Upload failed: invalid file type or save error");
        }

        System.out.println("Upload succeeded: saved as " + fileName);

        String imagePath = fileUploadService.getUploadDir() + File.separator + fileName;
        FlowerResultByPhoto flowerResult = MLClient.identifyFlower(imagePath);

        System.out.println("ML result: " + flowerResult.getName());

        return ResponseEntity.ok("Identified flower: " + flowerResult.getName());
    }
}
