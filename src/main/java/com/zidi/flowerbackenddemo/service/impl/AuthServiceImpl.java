package com.zidi.flowerbackenddemo.service.impl;

import com.zidi.flowerbackenddemo.dto.LoginRequest;
import com.zidi.flowerbackenddemo.dto.LoginResponse;
import com.zidi.flowerbackenddemo.entity.User;
import com.zidi.flowerbackenddemo.repository.UserRepository;
import com.zidi.flowerbackenddemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return new LoginResponse("success", "Login successful",user.getId());
            } else {
                return new LoginResponse("error", "Wrong password",user.getId());
            }
        } else {
            return new LoginResponse("error", "User not found", null);
        }
    }

    @Override
    public String logout(String email) {
        return "User " + email + " logged out.";
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}