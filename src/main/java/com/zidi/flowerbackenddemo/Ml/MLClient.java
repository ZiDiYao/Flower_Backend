package com.zidi.flowerbackenddemo.Ml;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zidi.flowerbackenddemo.dto.FlowerResultByPhoto;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

public class MLClient {

    private static final String ML_SERVER_URL = "http://127.0.0.1:5000/api/expert1";

    public static FlowerResultByPhoto identifyFlower(String imagePath) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            FileSystemResource fileResource = new FileSystemResource(new File(imagePath));
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", fileResource);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(ML_SERVER_URL, requestEntity, String.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(response.getBody());

                JsonNode flower1 = root.path("flower1");
                String name = flower1.path("name").asText();
                double confidence = flower1.path("confidence").asDouble();

                return new FlowerResultByPhoto(name, confidence, null);
            } else {
                return new FlowerResultByPhoto("Unknown", 0.0, null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FlowerResultByPhoto("Error", 0.0, null);
        }
    }
}
