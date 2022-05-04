package com.example.backendeksamen3semester.model;

import javax.persistence.*;

@Entity
@Table(name = "newsletter")
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="newsletterid", updatable = false, nullable = false)
    private int newsletterid;

    @Column(name="email", updatable = true, nullable = false)
    private String email;

    public int getNewsletterid() {
        return newsletterid;
    }

    public void setNewsletterid(int newsletterid) {
        this.newsletterid = newsletterid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Newsletter{" +
                "newsletterid=" + newsletterid +
                ", email='" + email + '\'' +
                '}';
    }
}
