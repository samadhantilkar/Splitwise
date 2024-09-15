package com.example.Splitwise.services;

import com.example.Splitwise.dto.CreateGroupRequestDto;
import com.example.Splitwise.dto.UpdateGroupRequestDto;
import com.example.Splitwise.exceptions.InvalidIdException;
import com.example.Splitwise.model.Group;
import com.example.Splitwise.model.User;
import com.example.Splitwise.repositories.GroupRepository;
import com.example.Splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private UserRepository userRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository,UserRepository userRepository){
        this.groupRepository=groupRepository;
        this.userRepository=userRepository;
    }

    public Group createGroup(CreateGroupRequestDto requestDto)throws Exception{
//        Fetch The User
        Optional<User> optionalUser=userRepository.findById(requestDto.getCreatedBy());
        if(optionalUser.isEmpty()){
            throw new InvalidIdException("Invalid Admin Id");
        }
        Group group =new Group();
        group.setCreatedBy(optionalUser.get());
        group.setAdmins(List.of(optionalUser.get()));
        group.setName(requestDto.getName());

        List<User> participant=new ArrayList<>();

        for(Long id:requestDto.getParticipants()){
            Optional<User> user=userRepository.findById(id);
            if(user.isEmpty()){
                throw new InvalidIdException("Id Does Not Exist");
            }
            participant.add(user.get());
        }
        group.setParticipant(participant);
        group.setCreatedTime(new Date());

        Group savedGroup=groupRepository.save(group);

        return savedGroup;
    }

    public Group updateGroupName(UpdateGroupRequestDto requestDto)throws Exception{
        Optional<Group> optionalGroup=groupRepository.findById(requestDto.getUserid());
        if(optionalGroup.isEmpty()){
            throw new InvalidIdException("Group Not Found");
        }
        Group group= optionalGroup.get();
        group.setName(requestDto.getName());
        Group savedGroup=groupRepository.save(group);
        return group;
    }


}
