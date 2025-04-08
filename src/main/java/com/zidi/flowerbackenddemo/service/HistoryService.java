package com.zidi.flowerbackenddemo.service;

import java.util.List;

import com.zidi.flowerbackenddemo.dto.FlowerDisplayResult;
import com.zidi.flowerbackenddemo.entity.FlowerDescription;

public interface HistoryService {
    List<FlowerDisplayResult> getDisplayHistory(Long userId);
}
