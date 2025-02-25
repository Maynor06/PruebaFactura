package com.PruebaFacturas.prueba.Repositories;

import com.PruebaFacturas.prueba.Entitys.Cliente;
import com.PruebaFacturas.prueba.Entitys.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FacturasRepository extends JpaRepository<Facturas, Long> {

    List<Facturas> findByCliente(Cliente cliente);
    List<Facturas> findByFechaEmisionBetween(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
