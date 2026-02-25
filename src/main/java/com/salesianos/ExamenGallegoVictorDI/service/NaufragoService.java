package com.salesianos.ExamenGallegoVictorDI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salesianos.ExamenGallegoVictorDI.model.Naufrago;
import com.salesianos.ExamenGallegoVictorDI.repository.NaufragoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NaufragoService {

    private final NaufragoRepository naufragoRepository;

    public List<Naufrago> findAll() {
        return naufragoRepository.findAll();
    }

    public Optional<Naufrago> findById(Long id) {
        return naufragoRepository.findById(id);
    }

    public Naufrago save(Naufrago naufrago) {
        return naufragoRepository.save(naufrago);
    }

    public void deleteById(Long id) {
        naufragoRepository.deleteById(id);
    }

    public List<Object[]> countByNacionalidad() {
        return naufragoRepository.countByNacionalidad();
    }

    public List<Object[]> countBySexo() {
        return naufragoRepository.countBySexo();
    }
}