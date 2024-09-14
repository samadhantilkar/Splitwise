package com.example.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestDto {
    String name;
    Long phone_Number;
    String password;

}
