package com.zidi.flowerbackenddemo.controller;

import com.zidi.flowerbackenddemo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/upload")
public class UploadController {
    private final UploadService fileUploadService;

    public UploadController(UploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        System.out.println("Receive the ask of uploading photo");
        String fileName = fileUploadService.saveFile(file);
        if (fileName != null) {
            return ResponseEntity.ok("File uploaded successfully: " + fileName);
        } else {
            return ResponseEntity.badRequest().body("Invalid file type or upload failed.");
        }
    }
}
