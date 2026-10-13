package com.FastTrackLogistics.Transportistas.Repository;

import com.FastTrackLogistics.Transportistas.Model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportistaRepository extends JpaRepository<Transportista, Long> {}