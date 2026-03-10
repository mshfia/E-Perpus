package com.example.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.perpustakaan.model.Buku;
import com.example.perpustakaan.repository.BukuRepository;

@Controller
@RequestMapping("/buku")
public class BukuController {

    private final BukuRepository bukuRepository;

    public BukuController(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    // =====================
    // READ (List Buku)
    // =====================
    @GetMapping
    public String index(Model model) {
        model.addAttribute("listBuku", bukuRepository.findAll());
        return "buku/index";
    }

    // =====================
    // CREATE (Form Tambah)
    // =====================
    @GetMapping("/tambah")
    public String formTambah(Model model) {
        model.addAttribute("buku", new Buku());
        return "buku/form";
    }

    @GetMapping("/modal/tambah")
    public String modalTambah(Model model) {
        model.addAttribute("buku", new Buku());
        return "buku/modal_form";
    }

    // =====================
    // SAVE (Tambah / Edit)
    // =====================
    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Buku buku) {
        bukuRepository.save(buku);
        return "redirect:/buku";
    }

    // =====================
    // UPDATE (Form Edit)
    // =====================
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Long id, Model model) {
        Buku buku = bukuRepository.findById(id).orElse(null);
        model.addAttribute("buku", buku);
        return "buku/form";
    }

    @GetMapping("/modal/edit/{id}")
    public String modalEdit(@PathVariable Long id, Model model) {
        Buku buku = bukuRepository.findById(id).orElse(null);
        model.addAttribute("buku", buku);
        return "buku/modal_form";
    }

    // =====================
    // DELETE
    // =====================
    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        bukuRepository.deleteById(id);
        return "redirect:/buku";
    }
}
