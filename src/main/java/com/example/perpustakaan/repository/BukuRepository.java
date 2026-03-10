package com.example.perpustakaan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.perpustakaan.model.Buku;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    long countByTersedia(boolean tersedia);
    // Cari buku berdasarkan judul
    List<Buku> findByJudulContainingIgnoreCase(String judul);

    // Cari buku yang masih tersedia
    List<Buku> findByTersediaTrue();
}
