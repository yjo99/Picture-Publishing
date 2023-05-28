package com.jo.picPublising.persistance.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @NonNull
    private String email;
    private String address;
    private String password;

    @ManyToMany
    private Set<Roles> roles = new HashSet<>();

    public User(){}
    public User(String userName, String email, String address, String password){
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

}
