package com.zidi.flowerbackenddemo.controller;

import com.zidi.flowerbackenddemo.dto.LoginRequest;
import com.zidi.flowerbackenddemo.dto.LoginResponse;
import com.zidi.flowerbackenddemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin // 允许前端跨域访问
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/logout")
    public String logout(@RequestParam String email) {
        return authService.logout(email);
    }
}
