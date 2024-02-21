package com.example.oauthjwt.controller;

import com.example.oauthjwt.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Flutter에게 access token을 받고, jwt token을 생성하여 Flutter에게 전달하는 역할
@RestController
@RequestMapping("/api/auth")
public class SocialLoginController {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    // 수정 필요
    @PostMapping("/social-login")
    public String socialLogin(String accessToken) {
        return customOAuth2UserService.getJwtToken(accessToken);
    }
}
