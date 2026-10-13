package com.FastTrackLogistics.Rutas.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreRuta;

    @Column(nullable = false)
    private String zonaGeografica;

    @Column(nullable = false)
    private Double distanciaKm;

    @Column(nullable = false)
    private Integer tiempoEstimadoMin;
}