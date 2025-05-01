package com.zidi.flowerbackenddemo.service;

import com.zidi.flowerbackenddemo.dto.LoginRequest;
import com.zidi.flowerbackenddemo.dto.LoginResponse;
import com.zidi.flowerbackenddemo.entity.User;
import java.util.Optional;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    String logout(String email);

    Optional<User> findByEmail(String email);
}
