package com.jo.picPublising.persistance.models;

import jakarta.persistence.Entity;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @NonNull
    private String email;
    private String address;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(  name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public User(){}

    public User(String userName, String email, String address, String password, Set<Roles> roles){
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.password = password;
        this.roles = roles;
    }

}
