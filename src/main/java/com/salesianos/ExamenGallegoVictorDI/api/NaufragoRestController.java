package com.salesianos.ExamenGallegoVictorDI.api;

import com.salesianos.ExamenGallegoVictorDI.model.Naufrago;
import com.salesianos.ExamenGallegoVictorDI.service.NaufragoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/naufragos")
@RequiredArgsConstructor
public class NaufragoRestController {

    private final NaufragoService naufragoService;

    @GetMapping
    public List<Naufrago> getAll() {
        return naufragoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Naufrago> getById(@PathVariable Long id) {
        return naufragoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Naufrago> create(@RequestBody Naufrago naufrago) {
        return ResponseEntity.ok(naufragoService.save(naufrago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Naufrago> update(@PathVariable Long id, @RequestBody Naufrago naufrago) {
        return naufragoService.findById(id).map(n -> {
            naufrago.setId(id);
            return ResponseEntity.ok(naufragoService.save(naufrago));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        naufragoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}