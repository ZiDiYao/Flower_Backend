package com.zidi.flowerbackenddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zidi.flowerbackenddemo.dto.FlowerDisplayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import com.zidi.flowerbackenddemo.entity.IdentificationResult;
import com.zidi.flowerbackenddemo.entity.User;
import com.zidi.flowerbackenddemo.repository.FlowerDescriptionRepository;
import com.zidi.flowerbackenddemo.repository.IdentificationResultRepository;
import com.zidi.flowerbackenddemo.repository.UserRepository;
import com.zidi.flowerbackenddemo.service.HistoryService;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private FlowerDescriptionRepository flowerDescriptionRepository;

    @Override
    public List<FlowerDisplayResult> getDisplayHistory(Long userId) {
        List<FlowerDescription> flowers = flowerDescriptionRepository.findByUser_Id(userId);
        List<FlowerDisplayResult> results = new ArrayList<>();

        for (FlowerDescription flower : flowers) {
            IdentificationResult result = flower.getIdentificationResult();

            String flowerName = result != null ? result.getFlowerName() : "Unknown";
            Integer confidence = result != null ? result.getConfidence() : null;

            results.add(new FlowerDisplayResult(
                    flower.getImageName(),
                    flowerName,
                    confidence,
                    flower.getColor(),
                    flower.getPetals(),
                    flower.getSmell(),
                    flower.getLocation()
            ));
        }

        return results;
    }

}
