package com.example.backendeksamen3semester.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Galleri {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "galleriid", updatable = false, nullable = false)
    private int galleriid;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;


}
