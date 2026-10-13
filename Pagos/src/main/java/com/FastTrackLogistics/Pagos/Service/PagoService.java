package com.FastTrackLogistics.Pagos.Service;

import com.FastTrackLogistics.Pagos.Model.Pago;
import com.FastTrackLogistics.Pagos.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    @Autowired
    private PagoRepository repository;

    public Pago guardar(Pago pago) {
        return repository.save(pago);
    }

    public List<Pago> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Pago actualizar(Long id, Pago detalles) {
        return repository.findById(id).map(p -> {
            p.setEnvioId(detalles.getEnvioId());
            p.setMonto(detalles.getMonto());
            p.setMetodoPago(detalles.getMetodoPago());
            p.setEstado(detalles.getEstado());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Pago no encontrado con id: " + id);
        }
    }
}