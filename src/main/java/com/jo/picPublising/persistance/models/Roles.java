package com.jo.picPublising.persistance.models;

import lombok.Data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Data
public class Roles implements Serializable {

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
