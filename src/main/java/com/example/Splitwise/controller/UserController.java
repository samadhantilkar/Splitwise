package com.example.Splitwise.controller;

import com.example.Splitwise.dto.*;
import com.example.Splitwise.exceptions.InvalidNameException;
import com.example.Splitwise.exceptions.InvalidPasswordException;
import com.example.Splitwise.model.User;
import com.example.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserService userService;
    @Autowired
    UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PutMapping("/user/update")
    public UpdateUserRepsonseDto updateProfile(@RequestBody UpdateUserRequestDto updateUserRequestDto) throws Exception{
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

//     /user/get/id  ->@PathVariable
    @PostMapping("/user/register")
    public CreateUserResponseDto registerUser(@RequestBody CreateUserRequestDto createUserRequestDto) throws Exception {
        if(createUserRequestDto.getName().matches(".*\\d.*")){
            throw  new InvalidNameException("Name contains a number.");
        }
        User user=new User();
        user.setName(createUserRequestDto.getName());
        user.setPhone_number(createUserRequestDto.getPhone_Number());
        user.setPassword(createUserRequestDto.getPassword());

        User savedUser=userService.createUser(user);
        System.out.println(savedUser.getId()+" "+savedUser.getName() +" "+savedUser.getPassword()+" "+savedUser.getPhone_number());
        CreateUserResponseDto userResponseDto=new CreateUserResponseDto();
        userResponseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return userResponseDto;
    }
}
