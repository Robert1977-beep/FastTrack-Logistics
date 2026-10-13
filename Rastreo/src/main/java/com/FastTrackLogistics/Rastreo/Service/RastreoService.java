package com.FastTrackLogistics.Rastreo.Service;

import com.FastTrackLogistics.Rastreo.Model.Rastreo;
import com.FastTrackLogistics.Rastreo.Repository.RastreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RastreoService {
    @Autowired
    private RastreoRepository rastreoRepository;

    public Rastreo guardar(Rastreo rastreo) {
        return rastreoRepository.save(rastreo);
    }

    public List<Rastreo> obtenerTodos() {
        return rastreoRepository.findAll();
    }

    public Optional<Rastreo> obtenerPorId(Long id) {
        return rastreoRepository.findById(id);
    }

    public Rastreo actualizar(Long id, Rastreo detalles) {
        return rastreoRepository.findById(id).map(r -> {
            r.setEnvioId(detalles.getEnvioId());
            r.setLatitud(detalles.getLatitud());
            r.setLongitud(detalles.getLongitud());
            r.setEstadoActual(detalles.getEstadoActual());
            return rastreoRepository.save(r);
        }).orElseThrow(() -> new RuntimeException("Rastreo no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        if (rastreoRepository.existsById(id)) {
            rastreoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Registro de rastreo no encontrado con id: " + id);
        }
    }
}