package com.example.sociallogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import com.cos.securityex01.config.oauth.PrincipalOauth2UserService;

@Configuration // IoC 빈(bean)을 등록
public class SecurityConfig {

    //@Autowired
    //private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .requestMatchers("/user/**").authenticated()
//                // .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or
//                // hasRole('ROLE_USER')")
//                // .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and
//                // hasRole('ROLE_USER')")
//                .requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/loginProc")
//                .defaultSuccessUrl("/")
//                .and()
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint();
//                ///.userService(principalOauth2UserService);
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 설정 변경
                .csrf(csrf -> csrf.disable())
                // 권한 설정 변경
                .authorizeRequests(authz -> authz
                        .requestMatchers("/user/**").authenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                // 로그인 설정 변경
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/"))
                // OAuth2 로그인 설정 변경
                .oauth2Login(oauth2 -> oauth2
                                .loginPage("/login")
                        // userInfoEndpoint() 설정 변경 또는 삭제
                        // OAuth2 로그인 후처리 필요 시 여기에 추가
                );

        return http.build();
    }
}