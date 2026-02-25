package com.salesianos.ExamenGallegoVictorDI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianos.ExamenGallegoVictorDI.model.Habilidad;

public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
}