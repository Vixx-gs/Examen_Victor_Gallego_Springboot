package com.salesianos.ExamenGallegoVictorDI.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "naufragos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Naufrago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private Integer edad;

    @Column(length = 50)
    private String sexo;

    @Column(length = 100)
    private String isla;

    @Column(length = 50)
    private String nacionalidad;

    private LocalDate fechaRescate;

    @ManyToOne
    @JoinColumn(name = "habilidad")
    private Habilidad habilidad;
}