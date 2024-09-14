package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class UserExpenseHasToPay extends BaseModel{
//    UEP:U
//    1:1
//    M:1
    @ManyToOne
    User user;

//    UEP:E
//    1:1
//    M:1
    @ManyToOne
    Expense expense;
    int amount;
}
