package com.zidi.flowerbackenddemo.repository;

import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerDescriptionRepository extends JpaRepository<FlowerDescription, Long> {
}