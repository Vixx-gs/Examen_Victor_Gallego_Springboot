package com.salesianos.ExamenGallegoVictorDI.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habilidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 20)
    private String dificultad;

    private Integer experiencia;

    @Column(length = 50)
    private String categoria;
}