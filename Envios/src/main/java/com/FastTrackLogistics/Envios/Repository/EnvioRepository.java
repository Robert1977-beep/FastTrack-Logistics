package com.FastTrackLogistics.Envios.Repository;

import com.FastTrackLogistics.Envios.Model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {}