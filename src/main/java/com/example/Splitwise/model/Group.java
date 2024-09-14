package com.example.Splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;
@Entity(name = "Groups")
public class Group extends BaseModel{
    String name;
//    G:P
//    1:M
//    M:1
    @ManyToMany
    List<User> participant;

//    G:A
//    1:M
//    M:1
    @ManyToMany
    List<User> admins;

//    G::C
//    1:1
//    M:1
    @ManyToOne
    User createdBy;
    Date createdTime;
}
