package com.FastTrackLogistics.Facturacion.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pagoId;

    @Column(nullable = false, unique = true)
    private String numeroFactura;

    @Column(nullable = false)
    private Double impuestos;

    @Column(nullable = false)
    private Double montoTotal;
}