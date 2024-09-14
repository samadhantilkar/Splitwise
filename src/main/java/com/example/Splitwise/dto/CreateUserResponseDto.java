package com.example.Splitwise.dto;

import com.example.Splitwise.model.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserResponseDto extends ResponseDto{
    private User user;
    private ResponseStatusDto responseStatusDto;
}
