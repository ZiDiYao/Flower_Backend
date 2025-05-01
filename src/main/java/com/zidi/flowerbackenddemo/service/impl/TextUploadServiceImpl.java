//package com.zidi.flowerbackenddemo.service.impl;
//
//import com.zidi.flowerbackenddemo.dto.FlowerDescriptionRequest;
//import com.zidi.flowerbackenddemo.entity.FlowerDescription;
//import com.zidi.flowerbackenddemo.entity.User;
//import com.zidi.flowerbackenddemo.repository.FlowerDescriptionRepository;
//import com.zidi.flowerbackenddemo.repository.UserRepository;
//import com.zidi.flowerbackenddemo.service.TextUploadService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Service
//public class TextUploadServiceImpl implements TextUploadService {
//
//    @Autowired
//    private FlowerDescriptionRepository repository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public void saveDescription(FlowerDescriptionRequest request) {
//
//        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());
//
//        User user = optionalUser.orElseThrow(() ->
//                new IllegalArgumentException("User not found: " + request.getEmail()));
//
//        FlowerDescription entity = new FlowerDescription();
//        entity.setImageName(request.getImageName());
//
//        Map<String, String> desc = request.getDescription();
//        entity.setColor(desc.get("color"));
//        entity.setPetals(desc.get("petals"));
//        entity.setSmell(desc.get("smell"));
//        entity.setLocation(desc.get("location"));
//        entity.setUser(user);
//
//        repository.save(entity);
//    }
//
//}
