package com.personal.homework_second.controller;


import com.personal.homework_second.dto.LoginRequestDto;
import com.personal.homework_second.dto.LoginResponseDto;
import com.personal.homework_second.dto.SignupRequestDto;
import com.personal.homework_second.dto.SignupResponseDto;
import com.personal.homework_second.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userservice;

    @PostMapping("/api/signup")
    public SignupResponseDto signup(@Valid @RequestBody SignupRequestDto signupRequestDto, BindingResult result){
        // 회원가입 정보 유효성 확인
//        if(result.hasErrors()){
//            return Res
//        }
        return userservice.signup(signupRequestDto);
    }

    @ResponseBody
    @PostMapping("/api/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return userservice.login(loginRequestDto, response);
    }
}
