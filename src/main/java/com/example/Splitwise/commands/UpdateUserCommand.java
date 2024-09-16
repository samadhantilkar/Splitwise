package com.example.Splitwise.commands;

import com.example.Splitwise.controller.UserController;
import com.example.Splitwise.dto.UpdateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UpdateUserCommand implements Command{
    UserController userController;
    @Autowired
    public UpdateUserCommand(UserController userController){
        this.userController=userController;
    }

    @Override
    public boolean canExecute(String input) {
        List<String> params= Arrays.stream(input.split(" ")).toList();
        if(params.size()!=3){
            return false;
        }
        else if(params.get(0).equals(CommandKeyword.UPDATE_USER_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) throws Exception {
        UpdateUserRequestDto updateUserRequestDto=new UpdateUserRequestDto();
        List<String> params=Arrays.stream(input.split(" ")).toList();
        updateUserRequestDto.setPassword(params.get(2));
        updateUserRequestDto.setId(Long.parseLong(params.get(1)));
        userController.updateProfile(updateUserRequestDto);
    }
}
