package com.zidi.flowerbackenddemo.service;


import com.zidi.flowerbackenddemo.entity.FlowerDescription;

import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;

public interface TextUploadService {
    void saveDescription(FlowerDescriptionRequest request);
}
