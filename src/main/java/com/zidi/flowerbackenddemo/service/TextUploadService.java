package com.zidi.flowerbackenddemo.service;

import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;

public interface TextUploadService {
    void saveDescription(FlowerDescriptionRequest request);
}
