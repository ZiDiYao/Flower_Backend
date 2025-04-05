package com.zidi.flowerbackenddemo.service;

import com.zidi.flowerbackenddemo.dto.LoginRequest;
import com.zidi.flowerbackenddemo.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    String logout(String email);
}
