package com.example.backendeksamen3semester.model;

import javax.persistence.*;

@Entity
public class Nyhed {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "nyhed_id")
    private Long nyhedId;

    private String overskrift;
    private String introduktion;

    @Column(name = "resterende_tekst")
    private String resterendeTekst;

    public Nyhed() {
    }

    public Nyhed(Long nyhedId, String overskrift, String introduktion, String resterendeTekst) {
        this.nyhedId = nyhedId;
        this.overskrift = overskrift;
        this.introduktion = introduktion;
        this.resterendeTekst = resterendeTekst;
    }

    public Long getNyhedId() {
        return nyhedId;
    }

    public void setNyhedId(Long nyhedId) {
        this.nyhedId = nyhedId;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getIntroduktion() {
        return introduktion;
    }

    public void setIntroduktion(String introduktion) {
        this.introduktion = introduktion;
    }

    public String getResterendeTekst() {
        return resterendeTekst;
    }

    public void setResterendeTekst(String resterendeTekst) {
        this.resterendeTekst = resterendeTekst;
    }
}
