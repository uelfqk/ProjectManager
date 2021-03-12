package com.projectmanager.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/find-password", "/sign-up").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/sign-in").permitAll();

        http.logout()
                .logoutSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //TODO resources/static 에 있는 리소스들은 스프링 시큐리티를 적용하지 말라고 정의
        //     흔히 사용하는 staticResources 경로 .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
        // ----------------------------------------------------------------------------------------------------------
        //     2021.03.12 프론트엔드 라이브러리 설정
        //     1. npm 으로 bootstrap 을 다운 받고 html 파일 수정
        //     2. 스프링 시큐리티에 추가적으로 /node_modules/** 를 추가하여 js, css 등의 파일은
        //        인증 요청하지 않게 수정 - .mvcMatchers("/node_modules/**")
        web.ignoring()
                .mvcMatchers("/node_modules/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
