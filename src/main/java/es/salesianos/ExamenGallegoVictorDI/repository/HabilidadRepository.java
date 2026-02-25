package es.salesianos.ExamenGallegoVictorDI.repository;

import es.salesianos.ExamenGallegoVictorDI.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
}