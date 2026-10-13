package com.FastTrackLogistics.Transportistas.Service;

import com.FastTrackLogistics.Transportistas.Model.Transportista;
import com.FastTrackLogistics.Transportistas.Repository.TransportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportistaService {
    @Autowired
    private TransportistaRepository repository;

    public Transportista guardar(Transportista transportista) {
        return repository.save(transportista);
    }

    public List<Transportista> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Transportista> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Transportista actualizar(Long id, Transportista detalles) {
        return repository.findById(id).map(t -> {
            t.setNombre(detalles.getNombre());
            t.setLicencia(detalles.getLicencia());
            t.setVehiculo(detalles.getVehiculo());
            t.setDisponible(detalles.getDisponible());
            return repository.save(t);
        }).orElseThrow(() -> new RuntimeException("Transportista no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Transportista no encontrado con id: " + id);
        }
    }
}