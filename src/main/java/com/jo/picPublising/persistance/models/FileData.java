package com.jo.picPublising.persistance.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileName;

    private String url;

    @OneToOne
    private FileType type;
}
