package com.zidi.flowerbackenddemo.dto;

import java.util.Map;

public class FlowerDescriptionRequest {

    private String email;
    private String imageName;
    private Map<String, String> description;

    // Getter & Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter & Setter for imageName
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    // Getter & Setter for description
    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }
}
