package com.example.Splitwise.controller;

import com.example.Splitwise.dto.CreateUserRequestDto;
import com.example.Splitwise.dto.CreateUserResponseDto;

public class UserController {
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto){
        if(createUserRequestDto.getName().matches(".*\\d.*")){
            throw new
        }
    }
}
