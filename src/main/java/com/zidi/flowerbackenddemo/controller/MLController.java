package com.zidi.flowerbackenddemo.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public class MLController {
    private String url = "http://192.168.2.17:5000/expert1";

    public ResponseEntity<String> callModel(MultipartFile img) throws IOException {
        // store img in temp folder
        File tempFile = File.createTempFile("upload-", img.getOriginalFilename());
        img.transferTo(tempFile);

        //prepare the file as resource
        FileSystemResource resource = new FileSystemResource(tempFile);

        // headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // request body
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", resource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // send request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        // Clean up temp file
        tempFile.delete();
        return ResponseEntity.ok(response.getBody());
    }
}
