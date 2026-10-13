package com.FastTrackLogistics.Pagos.Repository;

import com.FastTrackLogistics.Pagos.Model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {}