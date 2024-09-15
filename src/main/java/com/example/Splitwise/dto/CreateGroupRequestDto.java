package com.example.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGroupRequestDto{
    private String name;
    private Long createdBy;
    private List<Long> participants;
}
