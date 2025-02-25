package com.PruebaFacturas.prueba.Services;

import com.PruebaFacturas.prueba.DTOs.FacturaDTO;
import com.PruebaFacturas.prueba.Entitys.Cliente;
import com.PruebaFacturas.prueba.Entitys.EstdoFactura;
import com.PruebaFacturas.prueba.Entitys.Facturas;
import com.PruebaFacturas.prueba.Repositories.ClienteRepository;
import com.PruebaFacturas.prueba.Repositories.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaService {

    private FacturasRepository facturasRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public FacturaService(FacturasRepository facturasRepository, ClienteRepository clienteRepository ) {
        this.facturasRepository = facturasRepository;
        this.clienteRepository = clienteRepository;
    }

    private FacturaDTO convertirADTO(Facturas factura){
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.setId(factura.getId());
        facturaDTO.setIdCliente(factura.getCliente().getId());
        facturaDTO.setFechaEmision(factura.getFechaEmision());
        facturaDTO.setTotal(factura.getValorTotal());
        facturaDTO.setEstado(factura.getEstado().name());
        return facturaDTO;
    }

    public List<FacturaDTO> buscarFacturasPorCliente(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return facturasRepository.findByCliente(cliente).stream()
                .map(facturas -> convertirADTO(facturas))
                .collect(Collectors.toList());

    }

    public void eliminarFactura(Long id) {
        facturasRepository.deleteById(id);

    }

    public FacturaDTO buscarFacturaPorId(Long id) {
        Facturas facturas = facturasRepository.findById(id).orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        return convertirADTO(facturas);
    }

    public FacturaDTO guardarFactura(FacturaDTO facturaDTO) {
        Facturas factura = new Facturas();
        Cliente cliente = clienteRepository.findById(facturaDTO.getIdCliente()).orElseThrow(() -> new RuntimeException("cliente no encontrado"));
        factura.setCliente(cliente);
        factura.setValorTotal(facturaDTO.getTotal());
        factura.setEstado(EstdoFactura.valueOf(facturaDTO.getEstado()));
        factura = facturasRepository.save(factura);

        return convertirADTO(factura);
    }

    public List<FacturaDTO> obtenerFacturasPorRangoFechas(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        return facturasRepository.findByFechaEmisionBetween(fechaInicial, fechaFinal)
                .stream().map(facturas -> convertirADTO(facturas))
                .collect(Collectors.toList());
    }

}
