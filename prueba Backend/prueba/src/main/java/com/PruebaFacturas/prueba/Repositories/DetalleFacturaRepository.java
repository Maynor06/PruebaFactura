package com.PruebaFacturas.prueba.Repositories;

import com.PruebaFacturas.prueba.Entitys.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {

    List<DetalleFactura> findByFacturaId(Long facturaId);
}
