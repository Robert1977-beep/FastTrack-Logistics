package com.FastTrackLogistics.Facturacion.Service;

import com.FastTrackLogistics.Facturacion.Model.Factura;
import com.FastTrackLogistics.Facturacion.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository repository;

    public Factura guardar(Factura factura) {
        return repository.save(factura);
    }

    public List<Factura> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Factura> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Factura actualizar(Long id, Factura detalles) {
        return repository.findById(id).map(f -> {
            f.setPagoId(detalles.getPagoId());
            f.setNumeroFactura(detalles.getNumeroFactura());
            f.setImpuestos(detalles.getImpuestos());
            f.setMontoTotal(detalles.getMontoTotal());
            return repository.save(f);
        }).orElseThrow(() -> new RuntimeException("Factura no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Factura no encontrada con id: " + id);
        }
    }
}