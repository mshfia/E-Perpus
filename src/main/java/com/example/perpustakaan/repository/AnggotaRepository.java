package com.example.perpustakaan.repository;

import com.example.perpustakaan.model.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Long> {

    // Cari anggota berdasarkan nomor anggota
    Anggota findByNomorAnggota(String nomorAnggota);
}
