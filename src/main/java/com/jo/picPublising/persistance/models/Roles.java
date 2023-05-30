package com.jo.picPublising.persistance.models;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Enumerated(EnumType.STRING)
    private ERoles role;

    public Roles(){

    }
    public Roles(ERoles role){
        this.role = role;
    }

}
