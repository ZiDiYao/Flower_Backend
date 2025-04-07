package com.zidi.flowerbackenddemo.service;

import java.util.List;

import com.zidi.flowerbackenddemo.entity.FlowerDescription;

public interface HistoryService {
    List<FlowerDescription> getHistory(String userId);
}
