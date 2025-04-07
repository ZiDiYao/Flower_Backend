package com.zidi.flowerbackenddemo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class FlowerDescription {

    // Getters & Setters
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPetals(String petals) {
        this.petals = petals;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setUser(User user) {
        this.user = user;
    }
}