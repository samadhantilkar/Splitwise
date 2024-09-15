package com.example.Splitwise.services.passwordencoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements PasswordEncoder{
    private final BCryptPasswordEncoder springBcryptEncoder=new BCryptPasswordEncoder();
    @Override
    public String getEncodedPassword(String password){
        return springBcryptEncoder.encode(password);
    }

    @Override
    public boolean matches(String realPassword, String hashedPassword) {
        return springBcryptEncoder.matches(realPassword,hashedPassword);
    }
}
