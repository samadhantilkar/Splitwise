package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
@Entity
public class UserExpensePaidBy extends BaseModel{
    @ManyToOne
    User user;
    @ManyToOne
    Expense expense;
    int amount;
}
