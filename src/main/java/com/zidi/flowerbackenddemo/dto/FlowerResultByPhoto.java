package com.zidi.flowerbackenddemo.dto;

public class FlowerResultByPhoto {
    private String name;
    private double confidence;
    private String imagePath;

    public FlowerResultByPhoto() {}

    public FlowerResultByPhoto(String name, double confidence, String imagePath) {
        this.name = name;
        this.confidence = confidence;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public double getConfidence() {
        return confidence;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
