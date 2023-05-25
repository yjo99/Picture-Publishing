package com.jo.picPublising.persistance.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data

@RequiredArgsConstructor
@AllArgsConstructor
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

    public User(){

    }

}
