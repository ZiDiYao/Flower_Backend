package com.zidi.flowerbackenddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FlowerDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;
    private String color;
    private String petals;
    private String smell;
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // Each description of flower now has each corresponding user account

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id")
    private IdentificationResult identificationResult; // Each flower description now has a corresponding identification result
}