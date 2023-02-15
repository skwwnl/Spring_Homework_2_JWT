package com.personal.homework_second.dto;


import lombok.Getter;

@Getter
public class LoginRequestDto {

    private String username;
    private String password;

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
