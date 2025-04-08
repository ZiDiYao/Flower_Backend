package com.zidi.flowerbackenddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDisplayResult {
    private String imageName;
    private String flowerName;
    private Integer confidence;
    private String color;
    private String petals;
    private String smell;
    private String location;
}
