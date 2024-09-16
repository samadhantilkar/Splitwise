package com.example.Splitwise.services;

import com.example.Splitwise.exceptions.InvalidIdException;
import com.example.Splitwise.model.User;
import com.example.Splitwise.repositories.UserRepository;
import com.example.Splitwise.services.passwordencoder.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService(UserRepository userRepository   ){
        this.userRepository=userRepository;
    }

    public User FindUserById(Long id)throws Exception{
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new InvalidIdException("Invalid User Id");
        }
        return user.get();
    }


    public User createUser(User user){
        user.setPassword(passwordEncoder.getEncodedPassword(user.getPassword()));
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
        optUser.setPassword(passwordEncoder.getEncodedPassword(user.getPassword()));
//        Saved User
        User savedUser=userRepository.save(optUser);
//        Return User
        return savedUser;
    }

    private boolean checkPasswordMatch(Long userId,String password){
        User user=userRepository.getById(userId);

        String encodedPass=passwordEncoder.getEncodedPassword(password);

        if(!passwordEncoder.matches(encodedPass,user.getPassword())){
            System.out.println("Password Error");
            return true;
        }else {
            System.out.println("Login Successful ");
        }
        return false;
    }
}
