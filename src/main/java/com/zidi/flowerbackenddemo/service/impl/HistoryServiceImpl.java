package com.zidi.flowerbackenddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

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
    
    @Autowired
    private IdentificationResultRepository identificationResultRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<FlowerDescription> getHistory(String userId) {
        try {
            Long userIdLong = Long.parseLong(userId);
            return flowerDescriptionRepository.findByUser_Id(userIdLong);
        } catch (NumberFormatException e) {
            // If userId is not a valid number, return an empty list
            return new ArrayList<>();
        }
    }
    
}
