package com.example.perpustakaan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "buku_fiksi")
public class BukuFiksi extends Buku {

    private String duniaCerita;

    public BukuFiksi() {
    }

    public String getDuniaCerita() {
        return duniaCerita;
    }

    public void setDuniaCerita(String duniaCerita) {
        this.duniaCerita = duniaCerita;
    }
}
