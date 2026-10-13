package com.FastTrackLogistics.Rutas.Service;

import com.FastTrackLogistics.Rutas.Model.Ruta;
import com.FastTrackLogistics.Rutas.Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;

    public Ruta guardar(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public List<Ruta> obtenerTodos() {
        return rutaRepository.findAll();
    }

    public Optional<Ruta> obtenerPorId(Long id) {
        return rutaRepository.findById(id);
    }

    public Ruta actualizar(Long id, Ruta detalles) {
        return rutaRepository.findById(id).map(r -> {
            r.setNombreRuta(detalles.getNombreRuta());
            r.setZonaGeografica(detalles.getZonaGeografica());
            r.setDistanciaKm(detalles.getDistanciaKm());
            r.setTiempoEstimadoMin(detalles.getTiempoEstimadoMin());
            return rutaRepository.save(r);
        }).orElseThrow(() -> new RuntimeException("Ruta no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        if (rutaRepository.existsById(id)) {
            rutaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ruta no encontrada con id: " + id);
        }
    }
}