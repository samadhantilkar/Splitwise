package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class GroupExpense extends BaseModel{
//    GE:G
//    1:1
//    M:1
    @ManyToOne
    Group group;

//    GE:E
//    1:1
//    1:1
    @OneToOne
    Expense expense;
}
