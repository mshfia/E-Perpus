package com.example.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.perpustakaan.repository.AnggotaRepository;
import com.example.perpustakaan.repository.BukuRepository;
import com.example.perpustakaan.repository.PeminjamanRepository;

@Controller
public class HomeController {

    private final BukuRepository bukuRepository;
    private final AnggotaRepository anggotaRepository;
    private final PeminjamanRepository peminjamanRepository;

    public HomeController(BukuRepository bukuRepository,
                          AnggotaRepository anggotaRepository,
                          PeminjamanRepository peminjamanRepository) {
        this.bukuRepository = bukuRepository;
        this.anggotaRepository = anggotaRepository;
        this.peminjamanRepository = peminjamanRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        long totalBuku = bukuRepository.count();
        long totalAnggota = anggotaRepository.count();
        long peminjamanAktif = peminjamanRepository.findByTanggalKembaliIsNull().size();
        long totalPeminjaman = peminjamanRepository.count();

        model.addAttribute("totalBuku", totalBuku);
        model.addAttribute("totalAnggota", totalAnggota);
        model.addAttribute("totalPeminjaman", totalPeminjaman);

        return "dashboard";
    }
} 