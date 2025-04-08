package com.zidi.flowerbackenddemo.controller;

import com.zidi.flowerbackenddemo.dto.FlowerDisplayResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import com.zidi.flowerbackenddemo.service.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<FlowerDisplayResult>> getHistory(@PathVariable Long userId) {
        List<FlowerDisplayResult> historyList = historyService.getDisplayHistory(userId);
        return ResponseEntity.ok(historyList);
    }

}
