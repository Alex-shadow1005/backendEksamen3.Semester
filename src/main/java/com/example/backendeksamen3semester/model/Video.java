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
public class Video {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "video_id", updatable = false, nullable = false)
    private int galleriid;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "video", unique = false, nullable = false, length = 100000)
    private byte[] video;

}
