package com.example.backendeksamen3semester.model;

import javax.persistence.*;

@Entity
public class OmOs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="om_os_id")
    private Long omOsId;
    private String overskrift;

    @Column(name="under_overskrift")
    private String underOverskrift;
    private String tekst;

    public OmOs() {
    }

    public OmOs(Long id, String overskrift, String underOverskrift, String tekst) {
        this.omOsId = id;
        this.overskrift = overskrift;
        this.underOverskrift = underOverskrift;
        this.tekst = tekst;
    }

    public Long getOmOsId() {
        return omOsId;
    }

    public void setOmOsId(Long id) {
        this.omOsId = id;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getUnderOverskrift() {
        return underOverskrift;
    }

    public void setUnderOverskrift(String underOverskrift) {
        this.underOverskrift = underOverskrift;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
