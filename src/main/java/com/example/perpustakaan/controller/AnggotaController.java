package com.example.perpustakaan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.perpustakaan.model.Anggota;
import com.example.perpustakaan.repository.AnggotaRepository;

@Controller
@RequestMapping("/anggota")
public class AnggotaController {

    private final AnggotaRepository anggotaRepository;

    public AnggotaController(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("listAnggota", anggotaRepository.findAll());
        return "anggota/index";
    }

    @GetMapping("/tambah")
    public String formTambah(Model model) {
        model.addAttribute("anggota", new Anggota());
        return "anggota/form";
    }

    @GetMapping("/modal/tambah")
    public String modalTambah(Model model) {
        model.addAttribute("anggota", new Anggota());
        return "anggota/modal_form";
    }

    @PostMapping("/simpan")
    public String simpan(@ModelAttribute Anggota anggota) {
        anggotaRepository.save(anggota);
        return "redirect:/anggota";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable Long id, Model model) {
        model.addAttribute("anggota",
                anggotaRepository.findById(id).orElse(null));
        return "anggota/form";
    }

    @GetMapping("/modal/edit/{id}")
    public String modalEdit(@PathVariable Long id, Model model) {
        model.addAttribute("anggota",
                anggotaRepository.findById(id).orElse(null));
        return "anggota/modal_form";
    }

    @GetMapping("/hapus/{id}")
    public String hapus(@PathVariable Long id) {
        anggotaRepository.deleteById(id);
        return "redirect:/anggota";
    }
}
