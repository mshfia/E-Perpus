package com.example.perpustakaan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "buku")
@Inheritance(strategy = InheritanceType.JOINED)
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String judul;

    @Column(nullable = false)
    private String pengarang;

    private String genre;

    @Column(nullable = false)
    private boolean tersedia = true;

    // =====================
    // CONSTRUCTOR
    // =====================
    public Buku() {
    }

    // =====================
    // GETTER & SETTER
    // =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
