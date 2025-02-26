package com.PruebaFacturas.prueba.Repositories;

import com.PruebaFacturas.prueba.Entitys.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCorreo(String correo);

}
