package com.example.Splitwise.controller;

import com.example.Splitwise.dto.*;
import com.example.Splitwise.model.Group;
import com.example.Splitwise.services.GroupService;
import com.example.Splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {
    private UserService userService;
    private GroupService groupService;
    @Autowired
    GroupController(UserService userService,GroupService groupService){
        this.userService=userService;
        this.groupService=groupService;
    }

    public CreateUserResponseDto createGroup(CreateGroupRequestDto createGroupRequest)throws Exception{
        Group updatedGroup=groupService.createGroup(createGroupRequest);
        CreateUserResponseDto responseDto=new CreateUserResponseDto();
        responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        return responseDto;
    }

    public UpdateUserRepsonseDto updateGroupName(UpdateGroupRequestDto requestDto){

    }
}
