package com.salesianos.ExamenGallegoVictorDI.controller;

import com.salesianos.ExamenGallegoVictorDI.service.NaufragoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/kpi")
@RequiredArgsConstructor
public class KpiController {

    private final NaufragoService naufragoService;

    @GetMapping
    public String kpi(Model model) {
        List<Object[]> porNacionalidad = naufragoService.countByNacionalidad();
        List<String> nacionalidadLabels = new ArrayList<>();
        List<Long> nacionalidadData = new ArrayList<>();
        for (Object[] row : porNacionalidad) {
            nacionalidadLabels.add(row[0] != null ? row[0].toString() : "Desconocida");
            nacionalidadData.add((Long) row[1]);
        }

        List<Object[]> porSexo = naufragoService.countBySexo();
        List<String> sexoLabels = new ArrayList<>();
        List<Long> sexoData = new ArrayList<>();
        for (Object[] row : porSexo) {
            sexoLabels.add(row[0] != null ? row[0].toString() : "Desconocido");
            sexoData.add((Long) row[1]);
        }

        model.addAttribute("nacionalidadLabels", nacionalidadLabels);
        model.addAttribute("nacionalidadData", nacionalidadData);
        model.addAttribute("sexoLabels", sexoLabels);
        model.addAttribute("sexoData", sexoData);

        return "kpi/dashboard";
    }
}