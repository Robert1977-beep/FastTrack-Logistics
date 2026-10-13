package com.FastTrackLogistics.Rastreo.Repository;

import com.FastTrackLogistics.Rastreo.Model.Rastreo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RastreoRepository extends JpaRepository<Rastreo, Long> {}