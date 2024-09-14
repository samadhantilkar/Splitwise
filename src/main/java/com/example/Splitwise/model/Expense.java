package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;
@Entity
public class Expense extends BaseModel{
    String description;

    @Enumerated
    Currency currency;

//    E:C
//    1:1
//    M:1
    @ManyToOne
    User createdBy;

//    E:P
//    1:M
//    M:1
    @ManyToMany
    List<User> participants;
    Date createdAt;
}
