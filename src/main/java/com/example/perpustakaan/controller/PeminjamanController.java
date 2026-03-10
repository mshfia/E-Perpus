package com.example.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.perpustakaan.model.Peminjaman;
import com.example.perpustakaan.repository.AnggotaRepository;
import com.example.perpustakaan.repository.BukuRepository;
import com.example.perpustakaan.repository.PeminjamanRepository;

@Controller
@RequestMapping("/peminjaman")
public class PeminjamanController {

    private final PeminjamanRepository peminjamanRepository;
    private final AnggotaRepository anggotaRepository;
    private final BukuRepository bukuRepository;

    public PeminjamanController(PeminjamanRepository peminjamanRepository,
                                AnggotaRepository anggotaRepository,
                                BukuRepository bukuRepository) {
        this.peminjamanRepository = peminjamanRepository;
        this.anggotaRepository = anggotaRepository;
        this.bukuRepository = bukuRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("listPeminjaman",
                peminjamanRepository.findAll());
        return "peminjaman/index";
    }

    @GetMapping("/modal/tambah")
    public String modalTambah(Model model) {
        model.addAttribute("peminjaman", new Peminjaman());
        model.addAttribute("listAnggota", anggotaRepository.findAll());
        model.addAttribute("listBuku", bukuRepository.findAll());
        return "peminjaman/modal_form";
    }

    @GetMapping("/modal/edit/{id}")
    public String modalEdit(@PathVariable Long id, Model model) {
        model.addAttribute("peminjaman",
                peminjamanRepository.findById(id).orElse(null));
        model.addAttribute("listAnggota", anggotaRepository.findAll());
        model.addAttribute("listBuku", bukuRepository.findAll());
        return "peminjaman/modal_form";
    }

    @PostMapping("/simpan")
    public String simpan(Peminjaman peminjaman) {
        // Ensure anggota and buku are managed entities
        if (peminjaman.getAnggota() != null && peminjaman.getAnggota().getId() != null) {
            peminjaman.setAnggota(anggotaRepository.findById(peminjaman.getAnggota().getId()).orElse(null));
        }
        if (peminjaman.getBuku() != null && peminjaman.getBuku().getId() != null) {
            peminjaman.setBuku(bukuRepository.findById(peminjaman.getBuku().getId()).orElse(null));
        }
        peminjamanRepository.save(peminjaman);
        return "redirect:/peminjaman";
    }
}
