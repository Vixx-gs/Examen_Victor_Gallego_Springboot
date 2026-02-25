package com.salesianos.ExamenGallegoVictorDI.controller;

import com.salesianos.ExamenGallegoVictorDI.model.Naufrago;
import com.salesianos.ExamenGallegoVictorDI.service.HabilidadService;
import com.salesianos.ExamenGallegoVictorDI.service.NaufragoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/naufragos")
@RequiredArgsConstructor
public class NaufragoController {

    private final NaufragoService naufragoService;
    private final HabilidadService habilidadService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("naufragos", naufragoService.findAll());
        return "naufragos/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("naufrago", new Naufrago());
        model.addAttribute("habilidades", habilidadService.findAll());
        return "naufragos/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Naufrago naufrago) {
        naufragoService.save(naufrago);
        return "redirect:/naufragos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        naufragoService.findById(id).ifPresent(n -> model.addAttribute("naufrago", n));
        model.addAttribute("habilidades", habilidadService.findAll());
        return "naufragos/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        naufragoService.deleteById(id);
        return "redirect:/naufragos";
    }
}