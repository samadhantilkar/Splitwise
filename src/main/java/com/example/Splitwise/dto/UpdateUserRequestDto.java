package com.example.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto extends ResponseDto{
    String password;
    Long id;
}
