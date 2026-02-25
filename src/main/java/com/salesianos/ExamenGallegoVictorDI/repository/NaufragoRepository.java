package com.salesianos.ExamenGallegoVictorDI.repository;

import com.salesianos.ExamenGallegoVictorDI.model.Naufrago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface NaufragoRepository extends JpaRepository<Naufrago, Long> {

    @Query("SELECT n.nacionalidad, COUNT(n) FROM Naufrago n GROUP BY n.nacionalidad")
    List<Object[]> countByNacionalidad();

    @Query("SELECT n.sexo, COUNT(n) FROM Naufrago n GROUP BY n.sexo")
    List<Object[]> countBySexo();
}