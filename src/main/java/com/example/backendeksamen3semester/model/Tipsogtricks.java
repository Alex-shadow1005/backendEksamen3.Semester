package com.example.backendeksamen3semester.model;

import javax.persistence.*;

@Entity
public class Tipsogtricks {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="tripsogtricks_id")
    private Long tipsogtricksId;
    @Column(name="tipsogtricks_name")
    private String tipsogtricksName;
    private String link;

    public Tipsogtricks() {
    }

    public Tipsogtricks(Long tipsogtricksId, String tipsogtricksName, String link) {
        this.tipsogtricksId = tipsogtricksId;
        this.tipsogtricksName = tipsogtricksName;
        this.link = link;
    }

    public String getTipsogtricksName() {
        return tipsogtricksName;
    }

    public void setTipsogtricksName(String tipsogtricksName) {
        this.tipsogtricksName = tipsogtricksName;
    }

    public Long getTipsogtricksId() {
        return tipsogtricksId;
    }

    public void setTipsogtricksId(Long tipsogtricksId) {
        this.tipsogtricksId = tipsogtricksId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
