package com.PruebaFacturas.prueba.Services;

import com.PruebaFacturas.prueba.DTOs.DetalleFacturaDTO;
import com.PruebaFacturas.prueba.Entitys.DetalleFactura;
import com.PruebaFacturas.prueba.Repositories.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleFacturaService {

    private DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    public DetalleFacturaService(DetalleFacturaRepository detalleFacturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    private DetalleFacturaDTO convertADTO(DetalleFactura detalleFactura) {

        DetalleFacturaDTO detalleFacturaDTO = new DetalleFacturaDTO();
        detalleFacturaDTO.setId(detalleFactura.getId());
        detalleFacturaDTO.setIdFactura(detalleFactura.getFactura().getId());
        detalleFacturaDTO.setDescripcion(detalleFactura.getDescripcion());
        detalleFacturaDTO.setCantidad(detalleFactura.getCantidad());
        detalleFacturaDTO.setPrecioUnitario(detalleFactura.getPrecioUnitario());
        detalleFacturaDTO.setSubtotal(detalleFactura.getSubtotal());

        return detalleFacturaDTO;
    }

    public List<DetalleFacturaDTO> obtenerDetalleFacturas(Long idFactura) {
        return detalleFacturaRepository.findByFacturaId(idFactura).stream()
                .map(detalleFactura -> convertADTO(detalleFactura))
                .collect(Collectors.toList());
    }

    public DetalleFacturaDTO save(DetalleFacturaDTO detalleDto) {
        DetalleFactura detalle = new DetalleFactura();
        detalle.setDescripcion(detalleDto.getDescripcion());
        detalle.setCantidad(detalleDto.getCantidad());
        detalle.setPrecioUnitario(detalleDto.getPrecioUnitario());
        detalle.setSubtotal(detalleDto.getSubtotal());

        detalle = detalleFacturaRepository.save(detalle);

        return convertADTO(detalle);

    }

}
