package com.jo.picPublising.persistance.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.util.ElementFilter;

@Entity
@Data
public class FileType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EFileType name;
}
