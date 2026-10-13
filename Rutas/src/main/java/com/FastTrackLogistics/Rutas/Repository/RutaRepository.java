package com.FastTrackLogistics.Rutas.Repository;

import com.FastTrackLogistics.Rutas.Model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {}