package com.FastTrackLogistics.Envios.Service;

import com.FastTrackLogistics.Envios.Model.Envio;
import com.FastTrackLogistics.Envios.Repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {
    @Autowired
    private EnvioRepository envioRepository;

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Optional<Envio> obtenerPorId(Long id) {
        return envioRepository.findById(id);
    }

    public Envio actualizar(Long id, Envio detalles) {
        return envioRepository.findById(id).map(e -> {
            e.setCodigoSeguimiento(detalles.getCodigoSeguimiento());
            e.setOrigen(detalles.getOrigen());
            e.setDestino(detalles.getDestino());
            e.setEstado(detalles.getEstado());
            return envioRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Envío no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        if (envioRepository.existsById(id)) {
            envioRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encuentra el envío con id: " + id);
        }
    }
}