//package com.zidi.flowerbackenddemo.controller;
//
//import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;
//import com.zidi.flowerbackenddemo.service.TextUploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/description")
//public class TextUploadController {
//
//    @Autowired
//    private TextUploadService textUploadService;
//
//    @PostMapping("/save")
//    public ResponseEntity<String> saveFlowerDescription(@RequestBody FlowerDescriptionRequest request) {
//        try {
//            System.out.println("Receiving text description:");
//            System.out.println("username: " + request.getEmail());
//            System.out.println("imageName: " + request.getImageName());
//            System.out.println("description: " + request.getDescription());
//
//            textUploadService.saveDescription(request);
//
//            return ResponseEntity.ok("Flower description saved successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Failed to save flower description.");
//        }
//    }
//}
