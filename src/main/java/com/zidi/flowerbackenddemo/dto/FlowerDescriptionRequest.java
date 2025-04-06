package com.zidi.flowerbackenddemo.dto;

import java.util.Map;

public class FlowerDescriptionRequest {
    private String imageName;
    private Map<String, String> description;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Map<String, String> getDescription() {
        return description;
    }

    public void setDescription(Map<String, String> description) {
        this.description = description;
    }
}
