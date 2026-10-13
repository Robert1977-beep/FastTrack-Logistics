package com.FastTrackLogistics.Notificaciones.Service;

import com.FastTrackLogistics.Notificaciones.Model.Notificacion;
import com.FastTrackLogistics.Notificaciones.Repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository repository;

    public Notificacion guardar(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    public List<Notificacion> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Notificacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Notificacion actualizar(Long id, Notificacion detalles) {
        return repository.findById(id).map(n -> {
            n.setUsuarioId(detalles.getUsuarioId());
            n.setCanal(detalles.getCanal());
            n.setMensaje(detalles.getMensaje());
            n.setEstadoEnvio(detalles.getEstadoEnvio());
            return repository.save(n);
        }).orElseThrow(() -> new RuntimeException("Notificación no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Notificación no encontrada con id: " + id);
        }
    }
}