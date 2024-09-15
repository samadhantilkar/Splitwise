package com.example.Splitwise.controller;

import com.example.Splitwise.dto.*;
import com.example.Splitwise.exceptions.InvalidNameException;
import com.example.Splitwise.exceptions.InvalidPasswordException;
import com.example.Splitwise.model.User;
import com.example.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    UserController(UserService userService)
    {
        this.userService=userService;
    }

    public UpdateUserRepsonseDto updateUser(UpdateUserRequestDto updateUserRequestDto) throws Exception{
        if(updateUserRequestDto.getPassword().length()<8){
            throw new InvalidPasswordException("Password Length less than 8");
        }
        User user=new User();
        user.setPassword(updateUserRequestDto.getPassword());
        user.setId(updateUserRequestDto.getId());

        User UpdatedUser=userService.updateUser(user);

        UpdateUserRepsonseDto updateUserRepsonseDto=new UpdateUserRepsonseDto();
        updateUserRepsonseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return updateUserRepsonseDto;
    }


    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws Exception {
        if(createUserRequestDto.getName().matches(".*\\d.*")){
            throw  new InvalidNameException("Name contains a number.");
        }
        User user=new User();
        user.setName(createUserRequestDto.getName());
        user.setPhone_number(createUserRequestDto.getPhone_Number());
        user.setPassword(createUserRequestDto.getPassword());

        User savedUser=userService.createUser(user);
        System.out.println(savedUser.getPassword());

        CreateUserResponseDto userResponseDto=new CreateUserResponseDto();
        userResponseDto.setUser(savedUser);
        userResponseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return userResponseDto;
    }
}
