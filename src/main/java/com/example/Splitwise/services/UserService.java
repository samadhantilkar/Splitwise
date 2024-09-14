package com.example.Splitwise.services;

import com.example.Splitwise.exceptions.InvalidIdException;
import com.example.Splitwise.model.User;
import com.example.Splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User createUser(User user){
           User savedUser= userRepository.save(user);
           return savedUser;
    }

    public User updateUser(User user) throws Exception{
//        Find User By Id
        Optional<User> optionalUser=userRepository.findById(user.getId());
        if(optionalUser.isEmpty()){
            throw new InvalidIdException("Id Not Found");
        }
        User optUser=optionalUser.get();
//        Set Password
        optUser.setPassword(user.getPassword());
//        Saved User
        User savedUser=userRepository.save(optUser);
//        Return User
        return savedUser;
    }
}
