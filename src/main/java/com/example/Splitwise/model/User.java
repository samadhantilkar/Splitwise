package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Users")
@Getter
@Setter
public class User extends BaseModel{
    String name;
    Long phone_number;
    String password;
}
