package com.example.backendeksamen3semester.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Hold {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "hold_id")
    private Long holdId;
    private String name;
    private String underOverskrift;
    private String tekst;

    public Hold(){

    }

    public Hold(Long holdId, String name, String underOverskrift, String tekst) {
        this.holdId = holdId;
        this.name = name;
        this.underOverskrift = underOverskrift;
        this.tekst = tekst;
    }

    public String getUnderOverskrift() {
        return underOverskrift;
    }

    public void setUnderOverskrift(String underOverskrift) {
        this.underOverskrift = underOverskrift;
    }

    /**
    @Column(name = "image", unique = false, nullable = true, length = 100000)
    private byte[] image;
**/



    public Long getHoldId() {
        return holdId;
    }

    public void setHoldId(Long holdId) {
        this.holdId = holdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
/**
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
**/
    @Override
    public String toString() {
        return "Hold{" +
                "holdId=" + holdId +
                ", name='" + name + '\'' +
                ", tekst='" + tekst + '\'' +
                '}';
    }
}
