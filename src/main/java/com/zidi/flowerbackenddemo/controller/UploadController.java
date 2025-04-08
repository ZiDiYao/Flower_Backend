package com.zidi.flowerbackenddemo.controller;


import com.zidi.flowerbackenddemo.dto.FlowerResultByPhoto;
import com.zidi.flowerbackenddemo.dto.saveResultRequest;
import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import com.zidi.flowerbackenddemo.entity.IdentificationResult;
import com.zidi.flowerbackenddemo.entity.User;
import com.zidi.flowerbackenddemo.repository.FlowerDescriptionRepository;
import com.zidi.flowerbackenddemo.repository.IdentificationResultRepository;
import com.zidi.flowerbackenddemo.service.AuthService;

import com.zidi.flowerbackenddemo.service.UploadService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    private final UploadService fileUploadService;
    @Autowired
    private IdentificationResultRepository resultRepository;
    @Autowired
    private AuthService authService;

    @Autowired
    private FlowerDescriptionRepository descriptionRepository;

    public UploadController(UploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * Handles POST request to upload an image file
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
        //mlController.callModel(file);
        String fileName = fileUploadService.saveFile(file);
        if (fileName == null) {
            System.out.println("Upload failed: unsupported file type or saving error");
            return ResponseEntity.badRequest().body("Upload failed: invalid file type or save error");
        }

        System.out.println("Upload succeeded: saved as " + fileName);


        String imagePath = fileUploadService.getUploadDir() + File.separator + fileName;
        FlowerResultByPhoto flowerResult = MLClient.identifyFlower(imagePath);

        System.out.println("ML result: " + flowerResult.getName());

        return ResponseEntity.ok(fileName);
    }

    @PostMapping("/saveResult")
    public ResponseEntity<?> saveResult(@RequestBody saveResultRequest request){
        Optional<User> userOpt = authService.findByEmail(request.email);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // save Result
        IdentificationResult result = new IdentificationResult();
        result.flowerName = request.result.name;
        result.confidence = request.result.confidence;
        resultRepository.save(result);

        // Save description with result linked
        FlowerDescription desc = new FlowerDescription();
        desc.imageName = request.imageName;
        desc.color = request.color;
        desc.petals = request.petals;
        desc.smell = request.smell;
        desc.location = request.location;
        desc.user = userOpt.get();
        desc.result = result;

        descriptionRepository.save(desc);
        return ResponseEntity.ok("Result saved successfully");
    }
}
