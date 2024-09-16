package com.example.Splitwise.commands;

import com.example.Splitwise.controller.UserController;
import com.example.Splitwise.dto.CreateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class RegisterUserCommand implements Command{
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController){
        this.userController=userController;
    }

    @Override
    public void execute(String input) throws Exception{
        CreateUserRequestDto requestDto=new CreateUserRequestDto();
        List<String> info=Arrays.stream(input.split(" ")).toList();
        requestDto.setName(info.get(1));
        requestDto.setPassword(info.get(3));
        requestDto.setPhone_Number(Long.parseLong(info.get(2)));
        this.userController.registerUser(requestDto);
    }


    @Override
    public boolean canExecute(String input){
//        Register nane phone_number password
//        ["Register","name","phone_number","password"]
        List<String> params= Arrays.stream(input.split(" ")).toList();

        if(params.size()!=4){
            return false;
        }
        if(!params.get(0).equals(CommandKeyword.REGISTER_USER_COMMAND)){
            return  false;
        }
        return true;
    }
}
