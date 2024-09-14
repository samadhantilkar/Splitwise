package com.example.Splitwise.model;

import jakarta.persistence.Entity;

@Entity(name = "Users")
public class User extends BaseModel{
    String name;
    Long phone_number;
    String password;
}
