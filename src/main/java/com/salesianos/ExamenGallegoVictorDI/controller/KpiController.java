package com.salesianos.ExamenGallegoVictorDI.controller;

import com.salesianos.ExamenGallegoVictorDI.service.NaufragoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/kpi")
@RequiredArgsConstructor
public class KpiController {

    private final NaufragoService naufragoService;

    @GetMapping
    public String kpi(Model model) {
        List<Object[]> porNacionalidad = naufragoService.countByNacionalidad();
        model.addAttribute("nacionalidadLabels", porNacionalidad.stream().map(o -> o[0].toString()).collect(Collectors.toList()));
        model.addAttribute("nacionalidadData", porNacionalidad.stream().map(o -> o[1].toString()).collect(Collectors.toList()));

        List<Object[]> porSexo = naufragoService.countBySexo();
        model.addAttribute("sexoLabels", porSexo.stream().map(o -> o[0].toString()).collect(Collectors.toList()));
        model.addAttribute("sexoData", porSexo.stream().map(o -> o[1].toString()).collect(Collectors.toList()));

        return "kpi/dashboard";
    }
}