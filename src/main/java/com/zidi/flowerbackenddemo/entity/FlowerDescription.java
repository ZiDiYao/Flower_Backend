package com.zidi.flowerbackenddemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="flower_description", schema = "flower_demo")
public class FlowerDescription {
    @Id @GeneratedValue
    public Long id;

    public String imageName;
    public String color;
    public String petals;
    public String smell;
    public String location;

    @ManyToOne
    public User user; // assumes you have a User entity with email

    @OneToOne
    @JoinColumn(name ="result_id")
    public IdentificationResult result;
}