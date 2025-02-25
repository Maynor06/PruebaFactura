package com.PruebaFacturas.prueba.Repositories;

import com.PruebaFacturas.prueba.Entitys.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pagos, Long> {

    List<Pagos> findByFacturaId(Long idFactura);
}
