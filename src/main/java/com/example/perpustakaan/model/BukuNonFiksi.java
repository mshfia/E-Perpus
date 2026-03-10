package com.example.perpustakaan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "buku_non_fiksi")
public class BukuNonFiksi extends Buku {

    private String bidangIlmu;

    public BukuNonFiksi() {
    }

    public String getBidangIlmu() {
        return bidangIlmu;
    }

    public void setBidangIlmu(String bidangIlmu) {
        this.bidangIlmu = bidangIlmu;
    }
}
