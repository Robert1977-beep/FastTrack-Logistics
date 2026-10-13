package com.FastTrackLogistics.Rastreo.Controller;

import com.FastTrackLogistics.Rastreo.Model.Rastreo;
import com.FastTrackLogistics.Rastreo.Service.RastreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rastreos")
public class RastreoController {
    @Autowired
    private RastreoService rastreoService;

    @GetMapping
    public ResponseEntity<List<Rastreo>> obtenerTodos() {
        return ResponseEntity.ok(rastreoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rastreo> obtenerPorId(@PathVariable Long id) {
        return rastreoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Rastreo> crear(@RequestBody Rastreo rastreo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rastreoService.guardar(rastreo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rastreo> actualizar(@PathVariable Long id, @RequestBody Rastreo detalles) {
        try {
            return ResponseEntity.ok(rastreoService.actualizar(id, detalles));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            rastreoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}