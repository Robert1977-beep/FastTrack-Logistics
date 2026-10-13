package com.FastTrackLogistics.Facturacion.Repository;

import com.FastTrackLogistics.Facturacion.Model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {}