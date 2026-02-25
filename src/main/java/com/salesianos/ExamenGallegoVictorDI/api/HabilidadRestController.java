package com.salesianos.ExamenGallegoVictorDI.api;

import com.salesianos.ExamenGallegoVictorDI.model.Habilidad;
import com.salesianos.ExamenGallegoVictorDI.service.HabilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habilidades")
@RequiredArgsConstructor
public class HabilidadRestController {

    private final HabilidadService habilidadService;

    @GetMapping
    public List<Habilidad> getAll() {
        return habilidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable Long id) {
        return habilidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Habilidad> create(@RequestBody Habilidad habilidad) {
        return ResponseEntity.ok(habilidadService.save(habilidad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidad> update(@PathVariable Long id, @RequestBody Habilidad habilidad) {
        return habilidadService.findById(id).map(h -> {
            habilidad.setId(id);
            return ResponseEntity.ok(habilidadService.save(habilidad));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        habilidadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}