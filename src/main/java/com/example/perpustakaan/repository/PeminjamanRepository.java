package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {

    // Semua peminjaman milik satu anggota
    List<Peminjaman> findByAnggotaId(Long anggotaId);

    // Cek peminjaman aktif (belum dikembalikan)
    List<Peminjaman> findByTanggalKembaliIsNull();
}
