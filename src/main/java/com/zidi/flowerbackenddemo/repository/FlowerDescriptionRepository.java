package com.zidi.flowerbackenddemo.repository;

import com.zidi.flowerbackenddemo.entity.FlowerDescription;
import com.zidi.flowerbackenddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlowerDescriptionRepository extends JpaRepository<FlowerDescription, Long> {
    List<FlowerDescription> findByUser_Id(Long userId);
    List<FlowerDescription> findByUser(User user);
}