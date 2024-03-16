package com.example.oauthjwt.dto;

import java.util.Map;

public class KakaoResponse implements OAuth2Response{

    private final Map<String, Object> attribute;
    private final Map<String, Object> kakaoAccount;
    private final Map<String, Object> profile;

    public KakaoResponse(Map<String, Object> attribute) {
        this.attribute = attribute;
        // "kakao_account" 정보를 먼저 추출합니다.
        this.kakaoAccount = (Map<String, Object>) attribute.get("kakao_account");
        // "kakao_account" 내부의 "profile" 정보를 추출합니다.
        this.profile = (Map<String, Object>) kakaoAccount.get("profile");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        // 사용자의 고유 ID를 추출합니다. "id" 필드는 attribute의 최상위에 있습니다.
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        // "kakao_account"에서 이메일 정보를 추출합니다.
        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getName() {
        // "profile"에서 사용자의 닉네임을 추출합니다.
        return (String) profile.get("nickname");
    }
}
