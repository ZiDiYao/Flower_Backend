package com.zidi.flowerbackenddemo.service.impl;

import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;
import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import com.zidi.flowerbackenddemo.repository.FlowerDescriptionRepository;
import com.zidi.flowerbackenddemo.service.TextUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class TextUploadServiceImpl implements TextUploadService {

    @Autowired
    private FlowerDescriptionRepository repository;

    @Override
    public void saveDescription(FlowerDescriptionRequest request) {
        FlowerDescription entity = new FlowerDescription();
        entity.setImageName(request.getImageName());

        Map<String, String> desc = request.getDescription();
        entity.setColor(desc.get("color"));
        entity.setPetals(desc.get("petals"));
        entity.setSmell(desc.get("smell"));
        entity.setLocation(desc.get("location"));

        repository.save(entity);
    }
}
