package com.salesianos.ExamenGallegoVictorDI.controller;

import com.salesianos.ExamenGallegoVictorDI.model.Habilidad;
import com.salesianos.ExamenGallegoVictorDI.service.HabilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/habilidades")
@RequiredArgsConstructor
public class HabilidadController {

    private final HabilidadService habilidadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("habilidades", habilidadService.findAll());
        return "habilidades/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("habilidad", new Habilidad());
        return "habilidades/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Habilidad habilidad) {
        habilidadService.save(habilidad);
        return "redirect:/habilidades";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        habilidadService.findById(id).ifPresent(h -> model.addAttribute("habilidad", h));
        return "habilidades/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        habilidadService.deleteById(id);
        return "redirect:/habilidades";
    }
}