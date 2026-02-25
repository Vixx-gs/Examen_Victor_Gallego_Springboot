package com.salesianos.ExamenGallegoVictorDI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salesianos.ExamenGallegoVictorDI.model.Habilidad;
import com.salesianos.ExamenGallegoVictorDI.repository.HabilidadRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabilidadService {

    private final HabilidadRepository habilidadRepository;

    public List<Habilidad> findAll() {
        return habilidadRepository.findAll();
    }

    public Optional<Habilidad> findById(Long id) {
        return habilidadRepository.findById(id);
    }

    public Habilidad save(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    public void deleteById(Long id) {
        habilidadRepository.deleteById(id);
    }
}