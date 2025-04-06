package com.zidi.flowerbackenddemo.controller;

import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;
import com.zidi.flowerbackenddemo.service.TextUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/description")
public class TextUploadController {

    @Autowired
    private TextUploadService textUploadService;

    @PostMapping("/save")
    public ResponseEntity<String> saveFlowerDescription(@RequestBody FlowerDescriptionRequest request) {

        textUploadService.saveDescription(request);
        System.out.println("imageName: " + request.getImageName());
        System.out.println("description: " + request.getDescription());

        return ResponseEntity.ok("Flower description saved successfully.");
    }
}
