package com.example.backendeksamen3semester.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Data
@Builder

public class Hold {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "hold_id")
    private Long holdId;
    private String name;

    @Column(name="under_overskrift")
    private String underOverskrift;
    private String tekst;
    private String pris;
    @Column(name="antal_kursister")
    private String antalKursister;

    private String type;
    @Column(name = "hold_image", unique = false, nullable = false, length = 100000)
    private byte[] holdImage;


    public Hold(){

    }

    public Hold(Long holdId, String name, String underOverskrift, String tekst, String pris, String antalKursister, String type, byte[] holdImage) {
        this.holdId = holdId;
        this.name = name;
        this.underOverskrift = underOverskrift;
        this.tekst = tekst;
        this.pris = pris;
        this.antalKursister = antalKursister;
        this.type = type;
        this.holdImage = holdImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getHoldImage() {
        return holdImage;
    }

    public void setHoldImage(byte[] holdImage) {
        this.holdImage = holdImage;
    }

    public String getAntalKursister() {
        return antalKursister;
    }

    public void setAntalKursister(String antalKursister) {
        this.antalKursister = antalKursister;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
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
