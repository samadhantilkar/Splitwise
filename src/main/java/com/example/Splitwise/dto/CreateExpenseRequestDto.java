package com.example.Splitwise.dto;

import com.example.Splitwise.model.Currency;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CreateExpenseRequestDto {
    private String description;
    private Currency currency;
    private Long userId;
    private List<Long> participantIds;
}
